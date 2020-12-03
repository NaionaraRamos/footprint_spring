package com.footprint.controller;

import java.util.List;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.footprint.controller.openapi.AnswerControllerOpenAPI;
import com.footprint.dto.AnswerDto;
import com.footprint.repositories.AnswerRepository;
import com.footprint.repositories.UserRepository;
import com.footprint.request.AnswerRequest;
import com.footprint.services.AnswerService;
import com.footprint.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController implements AnswerControllerOpenAPI {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	@PostMapping("/postanswer")
	public ResponseEntity<?> save(@RequestBody @Valid AnswerRequest answerRequest){
		
		AnswerDto answerDto = new AnswerDto();
		answerDto = answerService.save(answerRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(answerDto);
	}
	
	@GetMapping("/listallanswers")
	public List<AnswerDto> listAllAnswers(){
		return answerService.list();
	}
}