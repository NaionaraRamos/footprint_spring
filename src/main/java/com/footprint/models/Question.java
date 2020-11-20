package com.footprint.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotNull;

//import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull
	private String category;
	//@NotNull
	private String title;
	//@NotNull
	private String answerA;
	//@NotNull
	private int weightA;
	private String answerB;
	private int weightB;
	private String answerC;
	private int weightC;
	private String answerD;
	private int weightD;
	private String status;
}