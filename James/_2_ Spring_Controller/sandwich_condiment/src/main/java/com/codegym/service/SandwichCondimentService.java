package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class SandwichCondimentService implements ISandwichCondimentService {
    @Override
    public String[] search(String[] listCondiment) {
        String[] list;
        if (listCondiment!= null){
            list = listCondiment;
        } else {
            list = new String[]{"Nothing"};
        }
        return list;
    }
}
