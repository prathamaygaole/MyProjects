package com.micro.checkin.controllers;

import com.micro.checkin.services.checkinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private checkinService checkinservice;

    @GetMapping("/hello")
    public String run(){
        return "running checkin service";
    }
    
    @GetMapping("/{id}/checkin")
    public String checkin(@PathVariable int id){
        return this.checkinservice.checkin(id);
    }
   /* public ResponseEntity<User> run(@PathVariable int id){
        User u= bookingService.getRefDetail(id);
        if(u==null){
            return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(u));

    }
*/
}
