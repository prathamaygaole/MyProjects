package com.searchservice.controller;

import com.searchservice.entity.AvailableFlight;
import com.searchservice.entity.Flight;
import com.searchservice.exception.FlightServiceException;
import com.searchservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorInstanceof;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Flight> postdata(@RequestBody Flight flight) {
        Flight f = null;
        try {
            f = this.flightService.postdata(flight);
            System.out.println(flight);
            return ResponseEntity.of(Optional.of(f));
        }catch(Exception e){
            e.printStackTrace();

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
           // throw new FlightServiceException("Fill the data correctly..");


        }
    }

    @GetMapping("/allflights")
    public ResponseEntity<List<Flight>> getallflight(){
     List<Flight> flights= flightService.getallflight();
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.FOUND);
    }

    @GetMapping("/{flightNo}")
    public ResponseEntity<Flight> getdata(@PathVariable String flightNo){
        Flight flightno= flightService.getdata(flightNo);
        if(flightno==null){
            return new ResponseEntity<Flight>(flightno, HttpStatus.NOT_FOUND);
        }
       return ResponseEntity.of(Optional.of(flightno));
    }

    @GetMapping("/flightsearch")
    public ResponseEntity<AvailableFlight> getsearchflightwithfare(@RequestParam String from, @RequestParam String to, @RequestParam String date){
         AvailableFlight availableFlight = flightService.getsearchflightwithfare(from, to, date);
        return new ResponseEntity<AvailableFlight>(availableFlight, HttpStatus.OK);
    }

}

    // @GetMapping("/flightsearch")
    // public AvailableFlight getsearchflightwithfare(@RequestBody Flight flight){
    //     return this.flightService.getsearchflightwithfare(flight);
    // }
