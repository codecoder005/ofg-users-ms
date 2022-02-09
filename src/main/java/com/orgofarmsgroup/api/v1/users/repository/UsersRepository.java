package com.orgofarmsgroup.api.v1.users.repository;

import com.orgofarmsgroup.api.v1.users.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, String> {
}
