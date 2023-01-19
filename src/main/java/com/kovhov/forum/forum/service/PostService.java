package com.kovhov.forum.forum.service;

import com.kovhov.forum.forum.dto.PostDTO;
import com.kovhov.forum.forum.model.Posts.Post;
import com.kovhov.forum.forum.repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepo postRepo;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<PostDTO> returnAllPost(){
        List<Post> postFromDB = postRepo.findAll();
//        List<PostDTO> postDTOList = postFromDB.stream()
//                .map(x -> postToDTO(x))
//                .toList();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (int i=0; i<= postFromDB.size()-1; i++){
            postDTOList.add(new PostDTO(postFromDB.get(i)));
        }
        return postDTOList;
    }

    @Transactional
    public void savePost(Post post){
        postRepo.save(post);
    }

//    private Post dtoToPost(PostDTO postDTO){
//        return mapper.map(postDTO, Post.class);
//    }
//
//    private PostDTO postToDTO(Post post){
//        return mapper.map(post, PostDTO.class);
//    }
}