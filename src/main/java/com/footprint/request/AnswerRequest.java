package com.footprint.request;

import java.util.Date;
import com.footprint.models.Question;
import com.footprint.models.User;
import lombok.Data;

@Data
public class AnswerRequest {
	
	private Long id;
	private User user;
	private Date date;
	private Question question;
	private String answer;
}