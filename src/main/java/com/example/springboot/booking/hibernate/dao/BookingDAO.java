package com.example.springboot.booking.hibernate.dao;

import com.example.springboot.booking.hibernate.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookingDAO {
    private EntityManager entityManager;

    @Autowired
    public BookingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Booking> getAllBookings(){
        List<Booking> allBookings = entityManager.createQuery("SELECT b FROM Booking b").getResultList();
        return allBookings;
    }

    public Booking getBookingById(int id){
        Booking booking = entityManager.find(Booking.class, id);
        return booking;
    }

    public void save(Booking booking){
        entityManager.merge(booking);
    }

}
