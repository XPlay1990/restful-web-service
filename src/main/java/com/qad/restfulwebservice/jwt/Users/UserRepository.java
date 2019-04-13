package com.qad.restfulwebservice.jwt.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<JwtUser, Long> {
    JwtUser findByUsername(String username);
}
