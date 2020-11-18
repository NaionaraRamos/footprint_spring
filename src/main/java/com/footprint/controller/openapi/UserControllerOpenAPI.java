package com.footprint.controller.openapi;

import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.footprint.dto.UserDto;
import com.footprint.exception.config.Problem;
import com.footprint.models.User;
import com.footprint.request.UserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Usuário")
public interface UserControllerOpenAPI {
	
	@ApiOperation("Cadastrar um usuário")
	@ApiResponses({ @ApiResponse(code = 201, message = "Usuário Cadastrado", response = UserDto.class)})
	ResponseEntity<?> save(
			@ApiParam(name = "corpo", value = "Representação de um novo usuário", required = true)
			@Valid UserRequest userRequest);	
	
	@ApiOperation(value = "Buscar usuário pelo ID", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, message = "Buscar usuário pelo ID", response = UserDto.class),
		@ApiResponse(code = 404, message = "Usuário não encontrado", response = Problem.class)})
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<User> search(Long id);
	
	@ApiOperation(value = "Excluir usuário pelo ID", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 204, message = "Usuário excluído com sucesso", response = UserDto.class),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) })
	@ApiImplicitParam(name = "id", value = "ID a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<User> delete(Long id);
	

	@ApiOperation(value = "Atualizar usuário pelo ID", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Usuário atualizado com sucesso.", response = UserDto.class),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) })
	@ApiImplicitParam(name = "id", value = "Id a ser atualizado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<?> update(@ApiParam(name = "corpo", value = "Representação de um novo usuário", required = true) @Valid User user, Long id);
}