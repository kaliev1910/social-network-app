package org.example.java19_instagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java19_instagram.dto.CommentDto;
import org.example.java19_instagram.dto.PostDto;
import org.example.java19_instagram.dto.UserDto;
import org.example.java19_instagram.service.interfaces.CommentService;
import org.example.java19_instagram.service.interfaces.PostService;
import org.example.java19_instagram.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;


    @GetMapping("/login")
    public String showLoginForm() {
        return "/auth/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "auth/register";
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String signUp(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        if (userService.getUserByUsername(userDto.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.user", "There is already a user registered with the provided username");
            return "auth/register";
        }

        userService.signUp(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/")
    public String showFeedPage() {
        return "/index";
    }

    @GetMapping("/profile")
    public String getUserProfile(Model model, Authentication authentication) {
        UserDto user = userService.getUserByUsername(authentication.getName()).get();
        Long userId = (long) user.getUserId();
        List<PostDto> posts = postService.getUserPosts(authentication.getName());
//        List<CommentDto> comments = commentService;


        model.addAttribute("user", user);

        model.addAttribute("posts", posts);
//        model.addAttribute("comments", comments);
//        model.addAttribute("likes", likes);
//        model.addAttribute("subscribes", subscribes);

        return "users/index";
    }
}
