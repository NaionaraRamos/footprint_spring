package com.footprint.controller.openapi;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.footprint.dto.QuestionDto;
import com.footprint.exception.config.Problem;
import com.footprint.request.QuestionRequest;
import com.footprint.models.Question;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Pergunta")
public interface QuestionControllerOpenAPI {
	
	@ApiOperation("Cadastrar uma pergunta")
	@ApiResponses({ @ApiResponse(code = 201, message = "Pergunta Cadastrada", response = QuestionDto.class)})
	ResponseEntity<?> save(
		@ApiParam(name = "corpo", value = "Representação de uma nova pergunta", required = true)
		@Valid QuestionRequest questionRequest);
	
	@ApiOperation(value = "Buscar todas as perguntas", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar todas as perguntas", response = QuestionDto.class)})
	List<QuestionDto> listAllQuestions();
	
	@ApiOperation(value = "Buscar pergunta pelo ID", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar pergunta pelo ID", response = QuestionDto.class),
		@ApiResponse(code = 404, message = "Pergunta não encontrada", response = Problem.class)})
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Question> search(Long id);
	
	@ApiOperation(value = "Excluir pergunta pelo ID", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 204, message = "Pergunta excluída com sucesso", response = QuestionDto.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) })
	@ApiImplicitParam(name = "id", value = "ID a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Question> delete(Long id);
	
	@ApiOperation(value = "Atualizar pergunta pelo ID", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Pergunta atualizada com sucesso.", response = QuestionDto.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) })
	@ApiImplicitParam(name = "id", value = "Id a ser atualizado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<?> update(@ApiParam(name = "corpo", value = "Representação de uma nova pergunta", required = true) @Valid Question question, Long id);
}
