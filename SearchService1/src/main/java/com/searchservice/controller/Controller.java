package com.searchservice.controller;

import com.searchservice.entity.AvailableFlight;
import com.searchservice.entity.Flight;
import com.searchservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class Controller {

    @Autowired
    private FlightService flightService;
    
    @GetMapping("/check")
    public String run(){
        return "Running Flight Search MicroService";
    }

    @PostMapping("/addData")
    public String postdata(@RequestBody Flight flight){
        return this.flightService.postdata(flight);
    }


    @GetMapping("/allflights")
    public List<Flight> getallflight(){
        return this.flightService.getallflight();
    }

    @GetMapping("/{flightNo}")
    public Flight getdata(@PathVariable String flightNo){
        return this.flightService.getdata(flightNo);
    }

    @GetMapping("/flightsearch")
    public AvailableFlight getsearchflightwithfare(@RequestParam String from, @RequestParam String to, @RequestParam String date){
        return this.flightService.getsearchflightwithfare(from, to, date);
    }

}


    // @GetMapping("/flightsearch")
    // public AvailableFlight getsearchflightwithfare(@RequestBody Flight flight){
    //     return this.flightService.getsearchflightwithfare(flight);
    // }