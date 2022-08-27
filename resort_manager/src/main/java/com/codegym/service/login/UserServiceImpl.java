package com.codegym.service.login;

import com.codegym.repository.login.UserRepository;
import com.codegym.model.login.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void create(AppUser appUser) {
        userRepository.save(appUser);
    }
}
