package com.footprint.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.footprint.controller.openapi.QuestionControllerOpenAPI;
import com.footprint.dto.QuestionDto;
import com.footprint.models.Question;
import com.footprint.models.User;
import com.footprint.repositories.QuestionRepository;
import com.footprint.request.QuestionRequest;
import com.footprint.services.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/dashboard")
public class QuestionController implements QuestionControllerOpenAPI {
	
	@Autowired QuestionService questionService;
	@Autowired QuestionRepository questionRepository;
	
	@Override
	@PostMapping("/postquestion")
	public ResponseEntity<?> save(@RequestBody @Valid QuestionRequest questionRequest){
			
		QuestionDto questionDto = questionService.save(questionRequest);
		System.out.println(questionDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(questionDto);
	}

	@GetMapping("/listactivequestions")
	public List<Question> listActiveQuestions() {
		return questionRepository.listActiveQuestions();
	}
	
	@Override
	@GetMapping("/listallquestions")
	public List<QuestionDto> listAllQuestions() {
		return questionService.list();
	}

	@Override
	@GetMapping("/getquestion/{id}")
	public ResponseEntity<Question> search(@PathVariable Long id) {
		
		Optional<Question> question = questionService.search(id);
		
		if(question.isPresent()) {
			return ResponseEntity.ok(question.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/deletequestion/{id}")
	public ResponseEntity<Question> delete(@PathVariable Long id) {
		
		try {
			questionService.delete(id);
			return ResponseEntity.noContent().build();
			
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	@PutMapping("/updatequestion/{id}")
	public ResponseEntity<?> update(@RequestBody Question question, Long id) {
		Question currentQuestion = questionService.search(id).orElse(null);
		
		if(currentQuestion != null) {
			BeanUtils.copyProperties(question, currentQuestion, "id");
			
			questionService.update(currentQuestion);
			return ResponseEntity.ok(currentQuestion);
		}
		
		return ResponseEntity.notFound().build();
	}
	
//	@PutMapping("/updatequestion/{id}")
//	public void atualizar(@PathVariable Long id, @RequestBody Question question) {
//		Question questionQ = questionRepository.findById(id).get();
//		
//		questionQ.setTitle(question.getTitle());
//		
//		questionRepository.save(questionQ);
//	}
	
	
//	@Override
//	@PostMapping("/postquestion")
//	public ResponseEntity<?> save(@RequestBody @Valid QuestionRequest questionRequest){
//			
//		QuestionDto questionDto = questionService.save(questionRequest);
//		System.out.println(questionDto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(questionDto);
//	}
}