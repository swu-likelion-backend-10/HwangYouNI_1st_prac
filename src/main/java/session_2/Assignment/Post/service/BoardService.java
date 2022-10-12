package session_2.Assignment.Post.service;

import org.springframework.stereotype.Service;
import session_2.Assignment.Post.domain.Board;
import session_2.Assignment.Post.dto.BoardDto;
import session_2.Assignment.Post.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardlist(){
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board:boards){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .age(board.getAge())
                    .name(board.getName())
                    .depart(board.getDepart())
                    .title(board.getTitle())
                    .contents(board.getContents())
                    .introduction(board.getIntroduction())
                    .createdTime(board.getCreatedTime())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id){
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .age(board.getAge())
                .name(board.getName())
                .depart(board.getDepart())
                .introduction(board.getIntroduction())
                .title(board.getTitle())
                .contents(board.getContents())
                .createdTime(board.getCreatedTime())
                .modifiedTime(board.getModifiedTime())
                .build();
        return boardDto;
    }

    @Transactional
    public Long updatePost(Long id,BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다. "+id));
        board.update(boardDto);

        return id;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }


    @Transactional
    public List<BoardDto> searchPosts(String keyword) {
        List<Board> boards = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if(boards.isEmpty()) {
            return boardDtoList;
        }

        for(Board board:boards){
            boardDtoList.add(this.convertEntityToDto(board));
        }
        return boardDtoList;
    }

    private BoardDto convertEntityToDto(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .age(board.getAge())
                .name(board.getName())
                .depart(board.getDepart())
                .introduction(board.getIntroduction())
                .title(board.getTitle())
                .contents(board.getContents())
                .createdTime(board.getCreatedTime())
                .modifiedTime(board.getModifiedTime())
                .build();

    }

}
