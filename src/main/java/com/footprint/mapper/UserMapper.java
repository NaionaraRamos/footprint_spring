package com.footprint.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.footprint.dto.UserDto;
import com.footprint.models.User;
import com.footprint.request.UserRequest;

@Component
public class UserMapper {

	@Autowired
    private ModelMapper
    modelMapper;

    public User requestToModel(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }
    
    public UserDto modelToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }   
}