package com.micro.checkin.exception;

public class CheckinServiceException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    String message;
    public CheckinServiceException(String message){
      this.message= message;    }
    @Override
    public String getMessage(){
        return message;
    }
}
