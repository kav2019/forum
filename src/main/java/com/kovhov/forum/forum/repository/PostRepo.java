package com.kovhov.forum.forum.repository;

import com.kovhov.forum.forum.model.Posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
