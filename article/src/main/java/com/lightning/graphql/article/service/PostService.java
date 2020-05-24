package com.lightning.graphql.article.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lightning.graphql.article.entity.Post;
import com.lightning.graphql.repository.PostRepository;

@Service
public class PostService {
	
    private final PostRepository postRepo;
    
    public PostService(final PostRepository vehicleRepository) {
        this.postRepo = vehicleRepository ;
    }
    
    @Transactional
    public Post createPost(final String content) {
        final Post post = new Post();
        post.setContent(content);
        return this.postRepo.save(post);
    }
    
    @Transactional
    public List<Post> getAllPosts(final int count) {
        return this.postRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }
    
    @Transactional
    public Optional<Post> getPost(final int id) {
        return this.postRepo.findById(id);
    }
}