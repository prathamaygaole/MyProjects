package com.searchservice.exception;

public class FlightServiceException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    String message;
    public FlightServiceException(String message){
      this.message= message;    }
    @Override
    public String getMessage(){
        return message;
    }
}
