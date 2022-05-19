package com.example.springboot.booking.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookings1")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "booking_start")
    private String start;

    @Column(name = "booking_end")
    private String end;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private Customer customer;

//    @OneToOne
//    @JoinColumn(name = "room_id")
//    private Apartment room;


    public Booking() {
    }

    public Booking(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
