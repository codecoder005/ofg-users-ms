package com.orgofarmsgroup.api.v1.users.service;

import com.orgofarmsgroup.api.v1.users.entity.User;
import com.orgofarmsgroup.api.v1.users.request.model.CreateUserRequestModel;

import java.util.List;

public interface UsersService {
    Object createUser(CreateUserRequestModel request);
    Object getUser(String userId);

    List<User> getAllUsers();
}
