package com.orgofarmsgroup.api.v1.users.service.impl;

import com.orgofarmsgroup.api.v1.users.dto.UserDto;
import com.orgofarmsgroup.api.v1.users.entity.User;
import com.orgofarmsgroup.api.v1.users.repository.UsersRepository;
import com.orgofarmsgroup.api.v1.users.request.model.CreateUserRequestModel;
import com.orgofarmsgroup.api.v1.users.service.UsersService;
import com.orgofarmsgroup.api.v1.users.service.impl.util.UsersServiceUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsersServiceImpl implements UsersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);
    private UsersRepository usersRepository;
    private UsersServiceUtils usersServiceUtils;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, UsersServiceUtils usersServiceUtils){
        this.usersRepository = usersRepository;
        this.usersServiceUtils = usersServiceUtils;
    }

    @Override
    public ResponseEntity<Object> createUser(CreateUserRequestModel request) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            User draftedUser = modelMapper.map(request, User.class);
            String userId = usersServiceUtils.generateUniqueUserId();
            draftedUser.setUserId(userId);
            User newUser = this.usersRepository.save(draftedUser);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }catch (Exception e){
            request.setMessage("Unable to create user: "+e.getMessage());
            return new ResponseEntity<>(request, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Object getUser(String userId) {
        try{
            return this.usersRepository.findById(userId).get();
        }catch (NoSuchElementException nse){
            UserDto userDto = new UserDto();
            userDto.setUserId(userId);
            userDto.setMessage("No such user found");
            return userDto;
        }
    }
}
