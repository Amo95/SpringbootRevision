package com.jeimseu.service;

import com.jeimseu.model.Customer;
import com.jeimseu.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void persistUserData(){
        customerRepository.save(new Customer());
    }

    public List<Customer> fetchAllCustomerInfo(){
        return customerRepository.findAll();
    }
}
