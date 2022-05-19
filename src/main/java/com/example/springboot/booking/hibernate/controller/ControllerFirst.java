package com.example.springboot.booking.hibernate.controller;

import com.example.springboot.booking.hibernate.entity.Apartment;
import com.example.springboot.booking.hibernate.entity.Booking;
import com.example.springboot.booking.hibernate.entity.Customer;
import com.example.springboot.booking.hibernate.service.ApartmentService;
import com.example.springboot.booking.hibernate.service.BookingService;
import com.example.springboot.booking.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ControllerFirst {
    private CustomerService customerService;
    private ApartmentService apartmentService;
    private BookingService bookingService;
    private Customer tCustomer;

    @Autowired
    public ControllerFirst(CustomerService customerService, ApartmentService apartmentService,
                           BookingService bookingService) {
        this.customerService = customerService;
        this.apartmentService = apartmentService;
        this.bookingService = bookingService;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/customers")
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/showAll";
    }

    @GetMapping("/customers/{id}")
    public String showCustomers(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customers/showById";
    }

    @GetMapping("/customers/new")
    public String newCustomer(@ModelAttribute("customer") Customer customer) {
        return "customers/new";
    }

    @PostMapping("/customers")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/api/customers";
    }

    @GetMapping("/apartments")
    public String showAllApartment(Model model) {
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "apartments/showAll";
    }

    @GetMapping("/apartments/{id}")
    public String showApartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "apartments/showById";
    }

    @GetMapping("/apartments/new")
    public String newApartment(@ModelAttribute("apartment") Apartment apartment) {
        return "apartments/new";
    }

    @PostMapping("/apartments")
    public String createApartment(@ModelAttribute("apartment") Apartment apartment) {
        apartmentService.save(apartment);
        return "redirect:/api/apartments";
    }

    @GetMapping("/bookings")
    public String showAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings/showAll";
    }

    @GetMapping("/bookings/{id}")
    public String showBooking(@PathVariable("id") int id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        return "bookings/showById";
    }

    @GetMapping("/bookings/new")
    public String newBooking(Model model) {
        Customer customer = customerService.getCustomerById(1);
        Booking booking = new Booking();
        customer.addBooking(booking);
        //System.out.println(customer.getBookings().get(3).getId());
        model.addAttribute("customer", customerService.getCustomerById(1));
        model.addAttribute("booking", booking);

        return "bookings/new";
    }

    @PostMapping("/bookings")
    public String createBooking(@ModelAttribute("booking") Booking booking) {
//        List<Customer> customers = customerService.getAllCustomers();
//        //Customer customer = customerService.getCustomerById(1);
//        //Booking booking = new Booking();
//        //customer.addBooking(booking);
        //customerService.save(c);
        bookingService.save(booking);
        return "redirect:/api/bookings";
    }

}
