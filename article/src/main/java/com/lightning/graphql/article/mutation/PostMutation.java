package com.lightning.graphql.article.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lightning.graphql.article.entity.Post;
import com.lightning.graphql.article.service.PostService;

@Component
public class PostMutation implements GraphQLMutationResolver {

	@Autowired
	PostService postService;
	
	public Post writePost(final String content) {
        return this.postService.writePost(content);
    }
	
	public Post updatePost(final Integer id, final String content) {
        return this.postService.updatePost(id, content);
    }
	
	public Integer removePost(final Integer id) {
		return this.postService.removePost(id);
	}
}
