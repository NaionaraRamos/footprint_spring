package com.footprint.request;

import lombok.Data;
import javax.validation.constraints.Email;

@Data
public class UserRequest {
	
	private Long id;
	private String name;	
	private String surname;
	@Email
	private String mail;
	private String password;
}