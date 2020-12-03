package com.footprint.controller.openapi;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.footprint.dto.AnswerDto;
//import com.footprint.exception.config.Problem;
//import com.footprint.models.Answer;
import com.footprint.request.AnswerRequest;
//import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface AnswerControllerOpenAPI {
	
	@ApiOperation("Cadastrar uma resposta")
	@ApiResponses({ @ApiResponse(code = 201, message = "Resposta Cadastrada", response = AnswerDto.class)})
	ResponseEntity<?> save(
		@ApiParam(name = "corpo", value = "Representação de uma nova resposta", required = true)
		@Valid AnswerRequest answerRequest);
	
	@ApiOperation(value = "Buscar todas as respostas", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar todas as respostas", response = AnswerDto.class)})
	List<AnswerDto> listAllAnswers();
	
//	@ApiOperation(value = "Buscar resposta pelo ID", httpMethod = "GET")
//	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar resposta pelo ID", response = AnswerDto.class),
//		@ApiResponse(code = 404, message = "Resposta não encontrada", response = Problem.class)})
//	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
//	ResponseEntity<Answer> search(Long id);
}
