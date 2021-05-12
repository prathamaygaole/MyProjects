package com.fareservice.fareservice1.controller;

import com.fareservice.fareservice1.entity.Fare;
import com.fareservice.fareservice1.entity.FlightFare;
import com.fareservice.fareservice1.service.FareServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fare")
public class Controller {

    @Autowired
    private FareServices fareServices;
    
    @GetMapping("/check")
    public String run(){
        return "Search microservice successfully running...!!";
    }

    @PostMapping("/add")
    public ResponseEntity<Fare> postdata(@RequestBody Fare fare){
        Fare f = null;
        try{
            f = this.fareServices.postdata(fare);
            System.out.println(fare);
            return ResponseEntity.of(Optional.of(f));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();

        }
    }

    @GetMapping("/data")
    public ResponseEntity<List<Fare>> getdata(){
       List<Fare> fares=fareServices.getdata();
        return new ResponseEntity<List<Fare>>(fares, HttpStatus.FOUND);
    }

    @GetMapping("{flightno}")
    public ResponseEntity<Fare> getflight(@PathVariable String flightno){
      Fare flightNo =fareServices.getflight(flightno);
      if(flightNo==null){
            return new ResponseEntity<Fare>(flightNo, HttpStatus.NOT_FOUND);
      }
      return ResponseEntity.of(Optional.of(flightNo));
    }

    @GetMapping("/getAll")
    public ResponseEntity<FlightFare> getPrice(){
        FlightFare flightFare=fareServices.getPrice();
        return  new ResponseEntity<FlightFare>(flightFare, HttpStatus.FOUND);
    }

}
