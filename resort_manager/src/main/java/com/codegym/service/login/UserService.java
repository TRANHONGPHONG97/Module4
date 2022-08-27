package com.codegym.service.login;


import com.codegym.model.login.AppUser;

public interface UserService {
    AppUser findByUsername(String username);

    void create(AppUser appUser);
}
