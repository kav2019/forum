package com.kovhov.forum.forum.controllers;

import com.kovhov.forum.forum.model.Posts.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Slf4j
@Controller
public class HomeSOAPController {

//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }
//
//    @GetMapping("/news")
//    public String news(){
//        return "news";
//    }


    @GetMapping("/new_post") // send form new post to user
    public String getFormNewPost(Model model){
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/new_post") //save form new post from user
    public String saveNewPost(@ModelAttribute("post") Post post){
        post.setDateCreate(new Date());
        System.out.println(post.toString());

        return "posts";
    }
}
