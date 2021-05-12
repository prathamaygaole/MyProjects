package com.searchservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchservice.entity.Flight;
import com.searchservice.repository.Flightrepo;
import com.searchservice.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureMockMvc

//@WebMvcTest(FlightControllerTest.class)
public class FlightControllerTest {

   /* @Autowired
    public MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper;

    @MockBean
    public FlightService flightService;

    @MockBean
    public Flightrepo flightrepo;

    public FlightControllerTest() {
    }

    @Test
    public void getallflights() throws Exception {
        List<Flight> listflight = new ArrayList<>();
       // listflight.add(new Flight(1,"ST101","AMERICA","LONDON","2022-03-03","111"));
       // Mockito.when(flightService.getallflight()).thenReturn(listflight);

    //    String url="/allflights";
     //MvcResult mvcResult= mockMvc.perform(get(url)).andExpect(status().isOk ()).andReturn();
     //String actualJsonResponse =mvcResult.getResponse().getContentAsString();
     //System.out.println(actualJsonResponse);
     //String expectedJsonResponse = objectMapper.writeValueAsString(listflight);


    }

*/
}
