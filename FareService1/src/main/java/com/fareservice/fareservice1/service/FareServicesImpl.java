package com.fareservice.fareservice1.service;

import com.fareservice.fareservice1.entity.Fare;
import com.fareservice.fareservice1.entity.FlightFare;
import com.fareservice.fareservice1.repository.Farerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FareServicesImpl implements FareServices {

    @Autowired
    private Farerepo Farerepo;

    @Override
    public String postdata(Fare fare) {
        this.Farerepo.save(fare);
        return "Successfully added";
    }

    @Override
    public List<Fare> getdata() {
        return this.Farerepo.findAll();
    }
    

    @Override
    public FlightFare getPrice() {
        FlightFare p = new FlightFare(this.Farerepo.findAll());
        return p;
    }

    @Override
    public Fare getflight(String flightno) {
        return this.Farerepo.findByFlightno(flightno);
    }
    
}
