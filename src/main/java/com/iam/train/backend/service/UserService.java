package com.iam.train.backend.service;

import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.Exception.UserException;
import com.iam.train.backend.entity.User;
import com.iam.train.backend.repository.UserRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepo repository;

    public UserService(UserRepo userRepo) {
        this.repository = userRepo;
    }
    public User create(String email,String password,String name) throws BaseException {
        //validate
        if(Objects.isNull(email)){
            throw UserException.createemailnull();
        }
        if(Objects.isNull(password)){
            throw UserException.createpasswordnull();
        }
        if(Objects.isNull(name)){
            throw UserException.createnamenull();
        }

        //verrify
        if (repository.existsByEmail(email)) {
            throw UserException.createemailduplicate();
        }
        //save
        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);

        return repository.save(entity);
    }
}
