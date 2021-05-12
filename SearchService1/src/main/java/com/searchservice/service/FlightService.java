package com.searchservice.service;

import com.searchservice.entity.AvailableFlight;
import com.searchservice.entity.Flight;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FlightService {
    public List<Flight> getallflight();
    public List<Flight> getdata();
    public Flight getdata(@PathVariable String flightNo);
    public Flight postdata(@RequestBody Flight flight);
    public AvailableFlight getsearchflightwithfare(@RequestParam String from, @RequestParam String to, @RequestParam String date);
}
