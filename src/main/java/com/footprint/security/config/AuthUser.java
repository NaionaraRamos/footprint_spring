package com.footprint.security.config;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import lombok.Getter;

@Getter
public class AuthUser extends User {

private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String nomeCompleto;
	
	public AuthUser(com.footprint.models.User usuario, Collection<? extends GrantedAuthority> permissoes) {
		super(usuario.getMail(), usuario.getPassword(), permissoes);
		
		this.userId = usuario.getId();
		this.nomeCompleto = usuario.getName();
	}	
}