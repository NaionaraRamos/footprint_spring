package com.footprint.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.footprint.dto.UserDto;
import com.footprint.exception.UserNotFound;
import com.footprint.mapper.UserMapper;
//import com.footprint.models.EmailNotification;
import com.footprint.models.User;
import com.footprint.repositories.UserRepository;
import com.footprint.request.UserRequest;

@Service
public class UserService {
	
	@Autowired private UserRepository userRepository;
	@Autowired private UserMapper mapper;
	//@Autowired private NotificationService notificationService;
	
	@Transactional
	public UserDto save(UserRequest userRequest) {
		User user = mapper.requestToModel(userRequest);
		user.setMail(userRequest.getMail());
		//.sendMail(new EmailNotification("Pegada Ecológica", user.getMail(), "Obrigada por se cadastrar no Pegada Ecológica!"));
		return mapper.modelToDto(userRepository.save(user));
	}
	
	@Transactional
	public void update(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> search(Long id) {
		return userRepository.findById(id);
	}

	@Transactional
	public void delete(Long id) {
		
		try {
			userRepository.deleteById(id);
			userRepository.flush();
		
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFound(id);
		};			
	}

	public List<UserDto> list() {
		return userRepository.findAll().stream()
				.map(cli -> mapper.modelToDto(cli))
				.collect(Collectors.toList());
	}
}