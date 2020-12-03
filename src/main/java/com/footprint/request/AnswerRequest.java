package com.footprint.request;

import org.joda.time.LocalDate;
import lombok.Data;

@Data
public class AnswerRequest {
	
	private Long id;
	//private User user;
	//= SecurityContextHolder.getContext().getAuthentication().getName().;
	//private Long user;
	//private String user;
    private int monthAnswer = new LocalDate().getMonthOfYear();
    private int yearAnswer = new LocalDate().getYear();
    private int sumAlimentacao;
    private int sumAlojamento;
    private int sumConsumo;
    private int sumResiduos;
    private int sumTransporte;
}