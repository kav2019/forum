package com.kovhov.forum.forum.model.News;

import com.kovhov.forum.forum.model.User.User;
import lombok.Data;

import java.util.Date;

@Data
public class News {
    private String title;
    private TextNews textNews;
    private Date dateCreate;
    private User author;
}
