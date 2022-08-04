package com.codegym.service;

import org.springframework.stereotype.Service;
@Service
public class Calculator implements ICalculator {

    @Override
    public double calculator(double input) {
        return input * 23000;
    }
}
