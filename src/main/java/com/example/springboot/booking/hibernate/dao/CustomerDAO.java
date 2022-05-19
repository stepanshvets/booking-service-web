package com.example.springboot.booking.hibernate.dao;

import com.example.springboot.booking.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAO {
    private EntityManager entityManager;

    @Autowired
    public CustomerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = entityManager.createQuery("SELECT c FROM Customer c").getResultList();
        return allCustomers;
    }

    public Customer getCustomerById(int id){
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public void save(Customer customer){
        entityManager.merge(customer);
    }

//    public void saveCustomer(Customer customer){
//
//    }
//
//    public void getCustomer(int id){
//
//    }
//
//    public void deleteCustomer(int id){
//
//    }

}
