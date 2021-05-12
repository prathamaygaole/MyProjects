package com.searchservice.service;

import com.searchservice.entity.AvailableFlight;
import com.searchservice.entity.Fare;
import com.searchservice.entity.Flight;
import com.searchservice.entity.FlightFare;
import com.searchservice.repository.Flightrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Flightrepo flightrepo;

    @Override
    public String postdata(Flight flight) {
        this.flightrepo.save(flight);
        return "Your have Successfully added the data...!!";
    }

    @Override
    public List<Flight> getdata() {
        return this.flightrepo.findAll();
    }

    @Override
    public List<Flight> getallflight() {
        var flightfare = restTemplate.getForObject("http://fare-microservice/fare/getAll/", FlightFare.class);
        var f=flightfare.getFlightFare().stream().map(i->i.getFlightno()).collect(Collectors.toList());
        for(var i:this.flightrepo.findAll()){
            if(f.contains(i.getFlightno())){
                var index = i.getId();
                i.setFare(flightfare.getFlightFare().get(index-1).getPrice());
            }
        }
        return this.flightrepo.findAll();
    }

    @Override
    public AvailableFlight getsearchflightwithfare(String from, String to, String date) {
        List<Flight> AvailableFLightList = new ArrayList<>();
        var flightfare = restTemplate.getForObject("http://fare-microservice/fare/getAll/", FlightFare.class);
        var f=flightfare.getFlightFare().stream().map(i->i.getFlightno()).collect(Collectors.toList());
        for(var i:this.flightrepo.findAll()){
            if(i.getFrom().equals(from)
                && i.getTo().equals(to)
                && i.getDate().equals(date)
                && f.contains(i.getFlightno())){
                    var index = i.getId();
                    i.setFare(flightfare.getFlightFare().get(index-1).getPrice());
                    AvailableFLightList.add(i);
            }
        }
        AvailableFlight p = new AvailableFlight(AvailableFLightList);
        return p;
    }

    @Override
    public Flight getdata(String flightNo) {
        var fare = this.restTemplate.getForObject("http://fare-microservice/fare/"+flightNo, Fare.class);
        Flight flight=this.flightrepo.findByFlightno(flightNo);
        flight.setFare(fare.getPrice());
        return flight;
    }
    
}


