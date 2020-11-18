package com.footprint.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.footprint.dto.QuestionDto;
import com.footprint.models.Question;
import com.footprint.request.QuestionRequest;

@Component
public class QuestionMapper {

	@Autowired
    private ModelMapper modelMapper;

    public Question requestToModel(QuestionRequest questionRequest) {
        return modelMapper.map(questionRequest, Question.class);
    }
    
    public QuestionDto modelToDto(Question question) {
        return modelMapper.map(question, QuestionDto.class);
    }   
}