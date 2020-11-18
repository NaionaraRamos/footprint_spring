package com.footprint.models;
//package com.footprint.modelos;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Entity
//@Data
//@AllArgsConstructor
//public class Opcao {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String nome;
//	
//	private double peso;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Pergunta pergunta;
//}