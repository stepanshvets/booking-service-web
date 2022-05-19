package com.example.springboot.booking.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private int id;

    @Column(name = "apartment_address")
    private String address;

    @Column(name = "apartment_seats")
    private String seats;

    public Apartment() {
    }

    public Apartment(String address, String seats) {
        this.address = address;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
