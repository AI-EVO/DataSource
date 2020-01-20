package com.aievo.demo.repository;

import com.aievo.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRrepository {
    int count();
    int save(User user);
    int update(User user);
    int deleteById(Long id);
    List<User> findAll();
    List<User> findByName(String name);
    Optional<User> findById(Long id);
    String getNameById(Long id);
}
