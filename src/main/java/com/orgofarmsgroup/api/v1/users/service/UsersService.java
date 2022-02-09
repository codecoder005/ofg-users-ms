package com.orgofarmsgroup.api.v1.users.service;

import com.orgofarmsgroup.api.v1.users.request.model.CreateUserRequestModel;

public interface UsersService {
    Object createUser(CreateUserRequestModel request);
    Object getUser(String userId);
}
