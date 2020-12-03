package com.footprint.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.footprint.dto.AnswerDto;
import com.footprint.models.Answer;
import com.footprint.request.AnswerRequest;

@Component
public class AnswerMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Answer requestToModel(AnswerRequest answerRequest){
		return modelMapper.map(answerRequest, Answer.class);
	}
	
	public AnswerDto modelToDto(Answer answer) {
		return modelMapper.map(answer, AnswerDto.class);
	}
}