package com.example.springboot.booking.hibernate.service;

import com.example.springboot.booking.hibernate.dao.ApartmentDAO;
import com.example.springboot.booking.hibernate.entity.Apartment;
import com.example.springboot.booking.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApartmentService {
    private ApartmentDAO apartmentDAO;

    @Autowired
    public ApartmentService(ApartmentDAO apartmentDAO) {
        this.apartmentDAO = apartmentDAO;
    }

    @Transactional
    public List<Apartment> getAllApartments(){
        return apartmentDAO.getAllApartments();
    }

    @Transactional
    public Apartment getApartmentById(int id){
        return apartmentDAO.getApartmentById(id);
    }

    @Transactional
    public void save(Apartment apartment){
        apartmentDAO.save(apartment);
    }
}
