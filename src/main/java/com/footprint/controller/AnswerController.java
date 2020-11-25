//package com.footprint.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.footprint.dto.AnswerDto;
//import com.footprint.models.Answer;
//import com.footprint.repositories.AnswerRepository;
//import com.footprint.request.AnswerRequest;
//import com.footprint.services.AnswerService;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/answer")
//public class AnswerController {
//	
//	@Autowired AnswerService answerService;
//	@Autowired AnswerRepository answerRepository;
//	
//	@PostMapping("/postanswer")
//	public ResponseEntity<?> save(@RequestBody @Valid AnswerRequest answerRequest){
//		
//		AnswerDto answerDto = answerService.save(answerRequest);
//		System.out.println(answerDto);
//		//Answer answer  = answerService.save(answerRequest);
//		return ResponseEntity.status(HttpStatus.CREATED).body(answerDto);
//	}
//	
//	@GetMapping("/listallanswers")
//	public List<AnswerDto> listAllAnswers(){
//		return answerService.list();
//	}
//	
//	@GetMapping("/getanswer/{id}")
//	public ResponseEntity<Answer> search(@PathVariable Long id){
//		
//		Optional<Answer> answer = answerService.search(id);
//		
//		if(answer.isPresent()) {
//			return ResponseEntity.ok(answer.get());
//		}
//		return ResponseEntity.notFound().build();
//	}
//}