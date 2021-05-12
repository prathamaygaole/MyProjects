package com.fareservice.fareservice1.service;

import com.fareservice.fareservice1.entity.Fare;
import com.fareservice.fareservice1.entity.FlightFare;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FareServices {
    public FlightFare getPrice();
    public List<Fare> getdata();
    public Fare postdata(@RequestBody Fare fare);
    public Fare getflight(@PathVariable String flightno);
}
