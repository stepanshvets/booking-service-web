package com.example.springboot.booking.hibernate.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customers")
@AttributeOverride(name = "name", column = @Column(name = "customer_name"))
@AttributeOverride(name = "surname", column = @Column(name = "customer_surname"))
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_email")
    private String email;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "c_id")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Booking> bookings;

    public Customer() {
    }

    public Customer(String name, String surname, String email) {
        super(name, surname);
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking) {
        if (bookings == null) {
            bookings = new LinkedList<>();
        }
        bookings.add(booking);
        booking.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
