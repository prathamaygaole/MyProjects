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
    public Fare postdata(Fare fare) {

        return this.Farerepo.save(fare);
    }

    @Override
    public List<Fare> getdata() {
        return this.Farerepo.findAll();
    }
    

    @Override
    public FlightFare getPrice() {
        FlightFare f = new FlightFare(this.Farerepo.findAll());
        return f;
    }

    @Override
    public Fare getflight(String flightno) {
        return this.Farerepo.findByFlightno(flightno);
    }
    
}
