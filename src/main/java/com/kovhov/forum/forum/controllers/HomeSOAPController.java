package com.kovhov.forum.forum.controllers;

import com.kovhov.forum.forum.dto.PostDTO;
import com.kovhov.forum.forum.model.Posts.Post;
import com.kovhov.forum.forum.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@Slf4j
@Controller
public class HomeSOAPController {

    private final PostService postService;

    @Autowired
    public HomeSOAPController(PostService postService) {
        this.postService = postService;
    }

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
    public String saveNewPost(@ModelAttribute("post") PostDTO post){
        post.setDateCreate(new Date());
        System.out.println(post.toString());
        postService.savePost(post);
        return "redirect:/posts";
    }

// return all post
//    @GetMapping("/posts")
//    public String allPosts(Model model){
//        model.addAttribute("postlist", postService.returnAllPost());
//        return "posts";
//    }


    //   view post with pagination
    @GetMapping("/posts")
    public String allPosts(Model model,
                          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                          @RequestParam(value = "post_per_page", required = false, defaultValue = "10") int postPerPage){
        Page<Post> pages = postService.returnPostOnPage(page, postPerPage);
        int countPage = pages.getTotalPages();
        int[] range = IntStream.rangeClosed(0, countPage-1).toArray();
        model.addAttribute("postlist", pages);
        model.addAttribute("rangepage", range);
        model.addAttribute("perpage", postPerPage);
        return "posts";
    }
}
