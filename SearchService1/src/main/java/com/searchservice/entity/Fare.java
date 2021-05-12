package com.searchservice.entity;

public class Fare {
    private int id;
    private String flightno;
    private String price;

    public Fare() {
    }

    public Fare(int id, String flightno, String price) {
        this.id = id;
        this.flightno = flightno;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fare [flightno=" + flightno + ", fprice=" + price + ", id=" + id + "]";
    }
  
}
