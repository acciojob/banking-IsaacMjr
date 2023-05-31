package com.driver;

public class InsufficientBalanceException extends RuntimeException{
    InsufficientBalanceException(String errorMsg){
        super(errorMsg);
    }
}
