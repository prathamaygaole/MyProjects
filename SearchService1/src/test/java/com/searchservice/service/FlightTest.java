package com.searchservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchservice.controller.Controller;
import com.searchservice.entity.Flight;
import com.searchservice.repository.Flightrepo;
import com.searchservice.service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
public class FlightTest{

@Autowired
private MockMvc mockMvc;

   // @Autowired
  //  private FlightService flightService;
@Autowired
private ObjectMapper objectMapper;

    @MockBean
    public Flightrepo flightrepo;

    @Test
    public void testListFlights() throws Exception {
        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight(1, "BT101", "SFO", "NYC", "2022-03-03", "111"));
        flightList.add(new Flight(2, "BT102", "SFO", "NYC", "2022-04-04", "211"));

        Mockito.when(flightrepo.findAll()).thenReturn(flightList);
        String url = "/flight/allflights";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }

   /* @Test
    public void addFlightTest()
    {
        Flight flight = new Flight(1,"BT101","SFO","NYC","2022-09-09","111");
        Mockito.when(flightrepo.save(flight)).thenReturn(flight);
        assertEquals(flight, flightService.postdata(flight));
    }

 /*   private void assertEquals(Flight flight, String postdata) {
    }

    @Test
    public void testAllFlights()  {
       List<Flight> flightList = new ArrayList<>();
       flightList.add(new Flight(1, "BT101", "SFO", "NYC", "2022-03-03", "111"));
       flightList.add(new Flight(2, "BT102", "NYC", "SFO", "2022-04-04", "121"));
       when((Publisher<?>) flightrepo.findAll()).thenReturn(flightList);
       assertEquals(2,flightList, flightService.getallflight().size());
   }

    private void assertEquals(int i, List<Flight> flightList, int size) {
    }
//        String url ="flight/allflights";
//        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
//
//        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
//        System.out.println(actualJsonResponse);
//
//        String expectedJsonResponse = objectMapper.writeValueAsString(flightList);
//       assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
//        //it checks whether it is giving actual json response or not.
//    }


  /*  @Test
    public void testAddNewData(){
        Flight newFlight = new Flight(1,"BT103","NYC","SFO","2022-07-07","130");
        Flight savedFlight = new Flight()
    }
*/
}
