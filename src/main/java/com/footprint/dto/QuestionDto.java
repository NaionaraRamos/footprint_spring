package com.footprint.dto;

import lombok.Data;

@Data
public class QuestionDto {

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