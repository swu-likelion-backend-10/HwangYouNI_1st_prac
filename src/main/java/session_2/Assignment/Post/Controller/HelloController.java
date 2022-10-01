package session_2.Assignment.Post.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("Hello")
    public String hello(Model model){
        model.addAttribute("name","Likelion 10th Yunhee");
        return "hello";
    }
}
