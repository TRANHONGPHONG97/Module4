package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//Lỗi vè dữ liệu
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataInputException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataInputException(String message) {
        super(message);
    }
}
