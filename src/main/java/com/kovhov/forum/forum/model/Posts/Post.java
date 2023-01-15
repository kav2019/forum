package com.kovhov.forum.forum.model.Posts;

import com.kovhov.forum.forum.model.User.User;
import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private String title;
//    private TextPost textPost;
    private String textPost;
    private Date dateCreate;
    private String author;
}
