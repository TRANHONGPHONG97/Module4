package com.codegym.service;

import com.codegym.model.User;


import java.util.List;

public interface IRegisterService {
    void save(User user);
    List<User> findAll();
}