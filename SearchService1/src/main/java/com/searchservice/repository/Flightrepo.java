package com.searchservice.repository;

import com.searchservice.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Flightrepo extends MongoRepository<Flight,Integer>{
    Flight findByFlightno(String flightno);
}




