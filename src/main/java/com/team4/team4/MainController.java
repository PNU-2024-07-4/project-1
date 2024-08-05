package com.team4.team4;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {



    @GetMapping("/")
    public String root() {
        return "main_board";
    }
}
