package com.searchservice;

import com.searchservice.entity.Flight;
import com.searchservice.repository.Flightrepo;
import com.searchservice.service.FlightService;
import com.searchservice.service.FlightServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@TestComponent
class SearchService1ApplicationTests {
    @Autowired
    public Flightrepo flightrepo;
    @Autowired
    private FlightService flightService;


    @Test
    void contextLoads(){

}

    @Test
    public void testAllFlights()  {
        List<Flight> flightList = new ArrayList<>();
       // when((flightService.getallflight()).toArray(flightList)//(flightList);


        flightList.add(new Flight(1, "BT101", "SFO", "NYC", "2022-03-03", "111"));
       flightList.add(new Flight(2, "BT102", "SFO", "NYC", "2022-03-03", "121"));
        flightList.add(new Flight(3, "BT103", "NYC", "SFO", "2022-04-04", "151"));
        flightList.add(new Flight(4, "BT104", "NYC", "SFO", "2022-04-04", "155"));
        flightList.add(new Flight(7, "BT108", "SFO", "NYC", "2022-08-03", "121"));
        flightList.add(new Flight(9, "BT109", "NYC", "SFO", "2022-09-09", "130"));
        flightList.add(new Flight(6, "BT106", "NYC", "SFO", "2022-09-09", "120"));

        flightList.add(new Flight(5, "BT105", "NYC", "CFO", "2022-07-07", "119"));
        flightList.add(new Flight(8, "BT108", "NYC", "CFO", "2022-07-07", "200"));
        flightList.add(new Flight(10, "BT108", "NYC", "SFO", "2022-09-03", "134"));
        flightList.add(new Flight(11, "BT110", "UK", "NK", "2022-10-10", "200"));



        assertEquals(flightList.toString(), flightService.getallflight().toString());
        //flightrepo.getakkflight.toString()
    }
    @Test
    public void testpostflight(){

    }

}
