package com.footprint.services;

import java.util.List;
import java.util.Optional;
//import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.footprint.dto.QuestionDto;
//import com.footprint.mapper.AnswerMapper;
import com.footprint.mapper.QuestionMapper;
//import com.footprint.models.Answer;
import com.footprint.models.Question;
//import com.footprint.models.User;
import com.footprint.repositories.QuestionRepository;
//import com.footprint.repositories.UserRepository;
//import com.footprint.request.AnswerRequest;
import com.footprint.request.QuestionRequest;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private QuestionMapper mapper;
	
//	@Autowired
//	private AnswerMapper answerMapper;
	
	@Transactional
	public QuestionDto save(QuestionRequest questionRequest) {
		Question question = mapper.requestToModel(questionRequest);
		return mapper.modelToDto(questionRepository.save(question));
	}
	
	@Transactional
	public void update(Question question) {
		questionRepository.save(question);
	}
	
	public Optional<Question> search(Long id) {
		return questionRepository.findById(id);
	}

	@Transactional
	public void delete(Long id) {
		questionRepository.deleteById(id);
		questionRepository.flush();		
	}

	public List<QuestionDto> list() {
		return questionRepository.findAll()
				.stream().map(cli -> mapper.modelToDto(cli))
				.collect(Collectors.toList());
	}
}