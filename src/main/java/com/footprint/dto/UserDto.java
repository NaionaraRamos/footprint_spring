package com.footprint.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private Long id;
	private String name;	
	private String surname;			
	private String mail;
	private String password;
}