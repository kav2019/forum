package com.kovhov.forum.forum.dto;

import com.kovhov.forum.forum.model.Posts.Post;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PostDTO {

    public PostDTO(Post postFromDB) {
        this.id = postFromDB.getId();
        this.title = postFromDB.getTitle();
        this.textPost = postFromDB.getTextPost();
        this.dateCreate = postFromDB.getDateCreate();
        this.author = postFromDB.getAuthor();
    }

    public PostDTO() {
    }

    private long id;
    private String title;
    private String textPost;
    private Date dateCreate;
    private String author;

    // return date in format to usability
    public String displatenDate(){
        return new SimpleDateFormat("dd-MM-yyyy").format(dateCreate);
    }

    public String returnTitleToDisplay(){
        return author + " " + displatenDate();
    }

}
