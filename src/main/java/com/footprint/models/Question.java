package com.footprint.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable = false)
	private String category;
	@NotNull
	@Column(nullable = false)
	private String title;
	@NotNull
	@Column(nullable = false)
	private String answerA;
	@NotNull
	@Column(nullable = false)
	private int weightA;
	@NotNull
	@Column(nullable = false)
	private String answerB;
	@NotNull
	@Column(nullable = false)
	private int weightB;
	@NotNull
	@Column(nullable = false)
	private String answerC;
	@NotNull
	@Column(nullable = false)
	private int weightC;
	@NotNull
	@Column(nullable = false)
	private String answerD;
	@NotNull
	@Column(nullable = false)
	private int weightD;
	@NotNull
	@Column(nullable = false)
	private String status;
}