package com.alicia.springbootcrud.service;

import com.alicia.springbootcrud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);

}
