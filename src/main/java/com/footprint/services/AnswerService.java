package com.footprint.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.footprint.dto.AnswerDto;
import com.footprint.mapper.AnswerMapper;
import com.footprint.models.Answer;
//import com.footprint.models.User;
import com.footprint.repositories.AnswerRepository;
import com.footprint.request.AnswerRequest;

@Service
public class AnswerService {
	
	@Autowired private AnswerRepository answerRepository;
	@Autowired private AnswerMapper mapper;
	
	public AnswerDto save(AnswerRequest answerRequest) {
		Answer answer = mapper.requestToModel(answerRequest);
		//Answer answer = new Answer();
		
//		Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
//		String nameLoggedUser = loggedUser.getName();
//		User user = new User();
//		user.setName(nameLoggedUser);
//		answer.getUser().getId();
		
		return mapper.modelToDto(answerRepository.save(answer));
		//return answerRepository.save(answer);
	}
	
	@Transactional
	public void update(Answer answer) {
		answerRepository.save(answer);
	}
	
	public Optional<Answer> search(Long id){
		return answerRepository.findById(id);
	}
	
	public void delete(Long id) {
		answerRepository.deleteById(id);
		answerRepository.flush();
	}
	
	public List<AnswerDto> list(){
		return answerRepository.findAll()
				.stream().map(cli -> mapper.modelToDto(cli))
				.collect(Collectors.toList());
	}
}