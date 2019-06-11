package com.exception;

public class MyException extends Exception {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
    public MyException(String message){
        this.message=message;
    }
}
