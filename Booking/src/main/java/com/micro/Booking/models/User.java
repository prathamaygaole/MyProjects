package com.micro.Booking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String flightno;
    private String from;
    private String to;
    private String date;
    private String fare;
    private String checkin;

    public User() {
    }

    public User(int id, String firstname, String lastname, String gender, String email, String flightno,
                String from, String to, String date, String fare, String checkin) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.flightno = flightno;
        this.from = from;
        this.to = to;
        this.date = date;
        this.fare = fare;

        this.checkin = checkin;
    }

    public String getCheckin() {
        return checkin;
    }


    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setTo(String to) {
        this.to = to;
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
        return "User [checkin=" + checkin + ", date=" + date + ", email=" + email + ", fare=" + fare + ", firstname="
                + firstname + ", from=" + from + ", flightno=" + flightno + ", to=" + to
                + ", gender=" + gender + ", id=" + id + ", lastname=" + lastname + "]";
    }

}
