package com.lightning.graphql.article;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lightning.graphql.article.entity.Comment;
import com.lightning.graphql.article.entity.Post;
import com.lightning.graphql.repository.CommentRepository;
import com.lightning.graphql.repository.PostRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lightning.graphql.article"})
@EnableJpaRepositories("com.lightning.graphql.repository")
public class ArticleApplication {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private PostRepository postRepo;

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			commentRepo.deleteAll();
			commentRepo.flush();
			postRepo.deleteAll();
			postRepo.flush();
			
			postRepo.save(new Post("Content 1", new HashSet<>(Arrays.asList(new Comment("Comment 1"), new Comment("Comment 2")))));
			postRepo.save(new Post("Content 2", new HashSet<>(Arrays.asList(new Comment("Comment 3"), new Comment("Comment 4")))));
			postRepo.save(new Post("Content 3", new HashSet<>(Arrays.asList(new Comment("Comment 5")))));
			postRepo.save(new Post("Content 4", new HashSet<>(Arrays.asList(new Comment("Comment 6"), new Comment("Comment 7")))));
			postRepo.save(new Post("Content 5", new HashSet<>(Arrays.asList(new Comment("Comment 8"), new Comment("Comment 9"), new Comment("Comment 10")))));
		};
	}
	
}
