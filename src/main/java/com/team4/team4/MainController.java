package com.team4.team4;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Value("${custom.site.secretName}")
    private String siteSecretName;

    @GetMapping("/secret")
    @ResponseBody
    public String showSecret(Model model) {
        return "The secret name is!: " + siteSecretName;
    }

    @GetMapping("/")
    public String mainBoard(Model model) {
        return "redirect:/board/";
    }
}

