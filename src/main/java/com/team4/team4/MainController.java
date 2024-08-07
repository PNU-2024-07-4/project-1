package com.team4.team4;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String mainBoard(Model model) {
        return "redirect:/board/";
    }
}

