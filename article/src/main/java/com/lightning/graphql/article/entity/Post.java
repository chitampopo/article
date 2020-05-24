package com.lightning.graphql.article.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class Post {
	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	
	@Column
	String content;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private Set<Comment> comments = new HashSet();
	
	public Post(String content, Set<Comment> comments) {
		this.content = content;
		this.comments = comments;
	}
}
