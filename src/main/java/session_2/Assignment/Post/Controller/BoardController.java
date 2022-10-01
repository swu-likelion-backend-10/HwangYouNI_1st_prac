package session_2.Assignment.Post.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import session_2.Assignment.Post.dto.BoardDto;
import session_2.Assignment.Post.service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardDtoList = boardService.getBoardlist();
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }
    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(@PathVariable("no") Long id, BoardDto boardDto){
        boardService.updatePost(id, boardDto);
        return "redirect:/post/{no}";
    }

    @DeleteMapping("/post/delete/{no}")
    public String delete(@PathVariable("no") Long id){
        boardService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }

}