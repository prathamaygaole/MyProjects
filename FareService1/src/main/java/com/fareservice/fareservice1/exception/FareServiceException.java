package com.fareservice.fareservice1.exception;

public class FareServiceException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    String message;
    public FareServiceException(String message){
      this.message= message;    }
    @Override
    public String getMessage(){
        return message;
    }
}
