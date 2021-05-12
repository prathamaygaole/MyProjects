package com.micro.Booking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Flight {
    @Id
    private int id;
    private String flightno;
    private String from;
    private String to;
    private String date;
    private String fare;

    public Flight() {
    }

    public Flight(int id, String flightno, String from, String to, String date, String fare) {
        this.id = id;
        this.flightno = flightno;
        this.from = from;
        this.to = to;
        this.date = date;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setFlightfo(String flightto) {
        this.to = flightto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Flight [date=" + date + ", fare=" + fare + ", to=" + to + ", from=" + from
                + ", flightno=" + flightno + ", id=" + id + "]";
    }
    
}   