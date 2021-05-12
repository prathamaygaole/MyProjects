package com.fareservice.fareservice1.controller;

import com.fareservice.fareservice1.entity.Fare;
import com.fareservice.fareservice1.entity.FlightFare;
import com.fareservice.fareservice1.service.FareServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fare")
public class Controller {

    @Autowired
    private FareServices fareServices;
    
    @GetMapping("/hello")
    public String run(){
        return "Search microservice successfully running...!!";
    }

    @PostMapping("/add")
    public String postdata(@RequestBody Fare fare){
        return this.fareServices.postdata(fare);
    }

    @GetMapping("/data")
    public List<Fare> getdata(){
        return this.fareServices.getdata();
    }

    @GetMapping("{flightno}")
    public Fare getflight(@PathVariable String flightno){
        return this.fareServices.getflight(flightno);
    }

    @GetMapping("/getAll")
    public FlightFare getPrice(){
        return this.fareServices.getPrice();
    }
}
