package com.team4.team4.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        try {
            userService.create(userCreateForm.getUsername(),
                    userCreateForm.getEmail(), userCreateForm.getPassword1(), userCreateForm.getBio(),
                    userCreateForm.getContactNumber(), userCreateForm.getSocialMediaHandles());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        SiteUser loggedInUser = this.userService.getUser(principal.getName());
        model.addAttribute("loggedInUser", loggedInUser);

        return "profile_form";
    }

    @GetMapping("profile/modify")
    public String profileModify(@Valid UserCreateForm userCreateForm,
                                BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "profile_form";
        }
        SiteUser loggedInUser = this.userService.getUser(principal.getName());
        userCreateForm.setBio(loggedInUser.getBio());
        userCreateForm.setContactNumber(loggedInUser.getContactNumber());
        userCreateForm.setSocialMediaHandles(loggedInUser.getSocialMediaHandles());
        return "profile_modify";
    }
}