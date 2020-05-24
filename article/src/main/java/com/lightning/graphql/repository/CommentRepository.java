package com.lightning.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lightning.graphql.article.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
