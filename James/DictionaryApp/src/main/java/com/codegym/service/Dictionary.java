package com.codegym.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dictionary implements IDictionary{

    @Override
    public String search(String input) {
       if (dictionary.get(input) !=null){
           return dictionary.get(input);
       } else {
           return "Không hợp lệ!";
       }
    }
    static Map<String, String> dictionary = new LinkedHashMap<>();
    static {
        dictionary.put("Hello", "Xin chào");
    }
}
