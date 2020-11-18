package com.footprint.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.footprint.controller.openapi.UserControllerOpenAPI;
import com.footprint.dto.UserDto;
import com.footprint.models.User;
//import com.footprint.repositories.UserRepository;
import com.footprint.request.UserRequest;
import com.footprint.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerOpenAPI{
	
	@Autowired private UserService userService;
	//@Autowired private UserRepository userRepository;
	
	@Override
	@PostMapping("/register")
	public ResponseEntity<?> save(@RequestBody @Valid UserRequest userRequest){
			
		try {
			UserDto userDto = new UserDto();
			userRequest.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
			userDto = userService.save(userRequest);
			//userDto = userRepository.insertUser(userDto.getName(), userDto.getSurname(), userDto.getMail(), userDto.getPassword());
			System.out.println(userDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<User> search(@PathVariable Long id) {
		
		Optional<User> user = userService.search(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<UserDto> list() {
		return userService.list();
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable Long id) {
		
		try {
			userService.delete(id);
			return ResponseEntity.noContent().build();
			
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	@PutMapping("/update/{id}")
	//@PatchMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody User user, Long id) {
		User currentUser = userService.search(id).orElse(null);
		
		if(currentUser != null) {
			BeanUtils.copyProperties(user, currentUser, "id");
			
			userService.update(currentUser);
			return ResponseEntity.ok(currentUser);
		}
		
		return ResponseEntity.notFound().build();
	}
}