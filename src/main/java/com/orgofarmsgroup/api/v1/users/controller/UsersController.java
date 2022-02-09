package com.orgofarmsgroup.api.v1.users.controller;

import com.orgofarmsgroup.api.v1.users.dto.UserDto;
import com.orgofarmsgroup.api.v1.users.request.model.CreateUserRequestModel;
import com.orgofarmsgroup.api.v1.users.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UsersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    private UsersService usersService;
    private Environment environment;
    @Autowired
    public UsersController(UsersService usersService, Environment environment){
        this.usersService = usersService;
        this.environment = environment;
    }

    @GetMapping("/status")
    public String status(){
        return "Users API is Up and running on post: "+environment.getProperty("local.server.port");
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Object createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel){
        return this.usersService.createUser(createUserRequestModel);
    }

    @GetMapping(
            path = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Object getUser(@PathVariable String userId){
        return usersService.getUser(userId);
    }
}
