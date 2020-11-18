package com.footprint.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String category;
	private String title;
	private String answerA;
	private int weightA;
	private String answerB;
	private int weightB;
	private String answerC;
	private int weightC;
	private String answerD;
	private int weightD;
	private String status;
}