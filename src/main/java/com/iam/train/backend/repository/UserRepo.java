package com.iam.train.backend.repository;


import com.iam.train.backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/** ใช้จัดการ Database */
public interface UserRepo extends CrudRepository<User,String> {

    Optional<User> findByEmail(String email);


    boolean existsByEmail(String email);
}
