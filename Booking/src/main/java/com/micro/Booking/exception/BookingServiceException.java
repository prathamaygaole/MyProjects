package com.micro.Booking.exception;

public class BookingServiceException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    String message;
    public BookingServiceException(String message){
      this.message= message;    }
    @Override
    public String getMessage(){
        return message;
    }
}
