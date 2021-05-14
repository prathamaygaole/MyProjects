package com.searchservice.controller;

import com.searchservice.entity.AuthenticationRequest;
import com.searchservice.entity.AuthenticationResponse;
import com.searchservice.entity.AvailableFlight;
import com.searchservice.entity.Flight;
import com.searchservice.service.FlightService;
import com.searchservice.service.JwtUtil;
import com.searchservice.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("/flight")
public class Controller {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;



    @GetMapping("/check")
    public String run(){
        return "It is running...";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


         UserDetails userDetails = userDetailsService  //final
                .loadUserByUsername(authenticationRequest.getUsername());

         String jwt = jwtTokenUtil.generateToken(userDetails);  //final

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/addData")
    public String postdata(@RequestBody Flight flight){
        return this.flightService.postdata(flight);
    }

    @GetMapping("/allflights")
    public List<Flight> getallflight(){
        return this.flightService.getallflight();
    }

    @GetMapping("/{flightNo}")
    public Flight getdata(@PathVariable String flightNo){
        return this.flightService.getdata(flightNo);
    }

    @GetMapping("/flightsearch")
    public AvailableFlight getsearchflightwithfare(@RequestParam String from, @RequestParam String to, @RequestParam String date){
        return this.flightService.getsearchflightwithfare(from, to, date);
    }

}


/*  @PostMapping("/authanticate")
    public ResponseEntity<?> generateToken(@ResponseBody JwtRequest jwtRequest){
    try{
    authanticationManager.authanticate(new UsernamePasswordAuthanticationToken(jwtRequest
    .getName(), jwtRequest.getPassword()));
    }catch (Exception e){
        throw new UserNotFoundException("User Forbidden");
    }
   String token = jwtTokenUtil.generateToken(jwtRequest);
		 UserDetails userDetails = userDetailsService.loginAdminJwt(jwtRequest);
		return new ResponseEntity<>(new JwtAdminResponse(token, userDetails), HttpStatus.OK);
	}

    }*/
