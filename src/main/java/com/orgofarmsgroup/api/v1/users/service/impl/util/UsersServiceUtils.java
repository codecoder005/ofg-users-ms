package com.orgofarmsgroup.api.v1.users.service.impl.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsersServiceUtils {
    public String generateUniqueUserId(){
        return UUID.randomUUID().toString();
    }
}
