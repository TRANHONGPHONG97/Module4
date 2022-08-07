package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculation(String firstInput, String secondInput, String calculation) {
        double input1;
        double input2;
        double resultCalculation;
        String result = null;
        try {
            input1 = Double.parseDouble(firstInput);
            input2 = Double.parseDouble(secondInput);
            switch (calculation) {
                case "Add":
                    resultCalculation = input1 + input2;
                    result = String.valueOf(resultCalculation);
                    break;
                case "Sub":
                    resultCalculation = input1 - input2;
                    result = String.valueOf(resultCalculation);
                    break;
                case "Mul":
                    resultCalculation = input1 * input2;
                    result = String.valueOf(resultCalculation);
                    break;
                case "Div":
                    resultCalculation = input1 / input2;
                    if (input2 == 0) {
                        result = "Không thực hiện được phép chia cho 0";
                    } else {
                        result = String.valueOf(resultCalculation);
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}