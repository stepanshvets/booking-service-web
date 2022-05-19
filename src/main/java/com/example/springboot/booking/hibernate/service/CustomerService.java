package com.example.springboot.booking.hibernate.service;

import com.example.springboot.booking.hibernate.entity.Customer;
import com.example.springboot.booking.hibernate.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }

    @Transactional
    public Customer getCustomerById(int id){
        return customerDAO.getCustomerById(id);
    }

    @Transactional
    public void save(Customer customer){
        customerDAO.save(customer);
    }
}
