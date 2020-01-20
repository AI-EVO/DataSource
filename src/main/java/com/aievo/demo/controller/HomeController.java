package com.aievo.demo.controller;

import com.aievo.demo.model.User;
import com.aievo.demo.repository.JdbcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private JdbcUserRepository jdbcUserRrepository;

    @PostMapping(path = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Integer add(User user){
        return jdbcUserRrepository.save(user);
    }


    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAll(){
        return jdbcUserRrepository.findAll();
    }
}
