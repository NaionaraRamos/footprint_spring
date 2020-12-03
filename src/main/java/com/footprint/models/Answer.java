package com.footprint.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import lombok.Data;

@Data
@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user;
	
	@OneToOne
	private User user;
	
	private int monthAnswer;
    private int yearAnswer;
    private int sumAlimentacao;
    private int sumAlojamento;
    private int sumConsumo;
    private int sumResiduos;
    private int sumTransporte;
    
//    public User setUser(User user) {
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	user.setName(auth.getName());
//    	setUser((User) auth.getPrincipal());
//    	System.out.println(user.getName());
//    	return user;
//    }
}