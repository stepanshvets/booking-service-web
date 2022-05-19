package com.example.springboot.booking.hibernate.service;

import com.example.springboot.booking.hibernate.dao.BookingDAO;
import com.example.springboot.booking.hibernate.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {
    private BookingDAO bookingDAO;

    @Autowired
    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Transactional
    public List<Booking> getAllBookings(){
        return bookingDAO.getAllBookings();
    }

    @Transactional
    public Booking getBookingById(int id){
        return bookingDAO.getBookingById(id);
    }

    @Transactional
    public void save(Booking booking){
        bookingDAO.save(booking);
    }
}
