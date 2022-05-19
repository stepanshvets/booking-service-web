package com.example.springboot.booking.hibernate.dao;

import com.example.springboot.booking.hibernate.entity.Apartment;
import com.example.springboot.booking.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ApartmentDAO {
    private EntityManager entityManager;

    @Autowired
    public ApartmentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Apartment> getAllApartments(){
        List<Apartment> allApartments = entityManager.createQuery("SELECT a FROM Apartment a").getResultList();
        return allApartments;
    }

    public Apartment getApartmentById(int id){
        Apartment apartment = entityManager.find(Apartment.class, id);
        return apartment;
    }

    public void save(Apartment apartment){
        entityManager.merge(apartment);
    }
}
