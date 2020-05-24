package com.lightning.graphql.article.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lightning.graphql.article.entity.Post;
import com.lightning.graphql.article.service.PostService;

@Component
public class PostQuery implements GraphQLQueryResolver {
	@Autowired
	private PostService postService;

	public List<Post> getPosts(final int count) {
		return this.postService.getAllPosts(count);
	}

	public Optional<Post> getPost(final int id) {
		return this.postService.getPost(id);
	}
}
