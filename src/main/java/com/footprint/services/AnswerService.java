package com.footprint.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.footprint.dto.AnswerDto;
import com.footprint.mapper.AnswerMapper;
import com.footprint.models.Answer;
import com.footprint.models.User;
import com.footprint.repositories.AnswerRepository;
//import com.footprint.repositories.UserRepository;
import com.footprint.request.AnswerRequest;
import com.footprint.security.permissions.FootprintSecurity;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private AnswerMapper mapper;
	
//	@Transactional
//	public void salvarRespostas(List<AnswerRequest> answers, Long idUser) {
//		
//		List<Answer> resp = answers.stream()
//				.map(ans -> answerMapper.requestToModel(ans))
//				.collect(Collectors.toList());
//		
//		User user = userRepository.findById(idUser).get();  
//		resp = resp.stream().map(r -> r.setUsuario(user)).collect(Collectors.toList());
//		
//	}
	
	public AnswerDto save(AnswerRequest answerRequest) {
		Answer answer = mapper.requestToModel(answerRequest);
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = (User) auth.getPrincipal();
//		//User u = new User();
//		
//		//answer.getUser().setName(user);
//		
//		System.out.println("Nome: " + user);
		
		
//		FootprintSecurity fs = new FootprintSecurity();
//		Long id = fs.getUserId();
//		//fs.getUserId();
//		System.out.println(id);
		
		return mapper.modelToDto(answerRepository.save(answer));
	}
	
//	@Transactional
//	public void update(Answer answer) {
//		answerRepository.save(answer);
//	}
//	
//	public Optional<Answer> search(Long id){
//		return answerRepository.findById(id);
//	}
	
//	public void delete(Long id) {
//		answerRepository.deleteById(id);
//		answerRepository.flush();
//	}
//	
	public List<AnswerDto> list(){
		return answerRepository.findAll()
				.stream().map(cli -> mapper.modelToDto(cli))
				.collect(Collectors.toList());
	}
}