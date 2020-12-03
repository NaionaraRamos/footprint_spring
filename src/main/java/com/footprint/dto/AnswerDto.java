package com.footprint.dto;

import org.joda.time.LocalDate;
import lombok.Data;

@Data
public class AnswerDto {
	
	private Long id;
	//private Long user = new FootprintSecurity().getUserId();
	//private User user;
	//private String user;
    private int monthAnswer = new LocalDate().getMonthOfYear();
    private int yearAnswer = new LocalDate().getYear();
    private int sumAlimentacao;
    private int sumAlojamento;
    private int sumConsumo;
    private int sumResiduos;
    private int sumTransporte;
}
