package com.fareservice.fareservice1.repository;

import com.fareservice.fareservice1.entity.Fare;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Farerepo extends MongoRepository<Fare,Integer>{
    Fare findByFlightno(String flightno);
}
