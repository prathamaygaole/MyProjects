package com.micro.Booking.Controller;

import com.micro.Booking.models.User;
import com.micro.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class Controller {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/check")
    public String hello(){
        return "running booking service";
    }

    @GetMapping("/{flightno}")
    public ResponseEntity<User> getspecificflight(@PathVariable String flightno, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String gender, @RequestParam String email) {
        User u = null;
        try {
            u = this.bookingService.getspecificflight(flightno, firstname, lastname, gender, email);
            System.out.println(u);
            return ResponseEntity.of(Optional.of(u));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @GetMapping("/search/{id}")
    public ResponseEntity<User> run(@PathVariable int id){
        User u= bookingService.getRefDetail(id);
        if(u==null){
            return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(u));

    }
}

/*  // return this.bookingService.getspecificflight(flightno, firstname, lastname, gender, email);
        if(user==null){
            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(user));

    }*/