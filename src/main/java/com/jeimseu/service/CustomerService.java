package com.jeimseu.service;

import com.jeimseu.model.Customer;
import com.jeimseu.repository.CustomerRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer persistUserData(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> fetchAllCustomersInfo(){
        return customerRepository.findAll();
    }

    public Customer fetchAllCustomerInfoById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public String deleteCustomerById(Long id){
        String message;
        try {
            customerRepository.deleteById(id);
            message = "Customer deleted successfully!";
        } catch (EmptyResultDataAccessException exception) {
            message = "id not found!";
        }
        return message;
    }

    public Customer updateCustomerInfoById(Long id, Customer customer){
        return customerRepository.findById(id)
                .stream()
                .map(customer1 -> updateCustomer(customer, customer1))
                .findFirst()
                .orElse(null);
    }

    private Customer updateCustomer(Customer customer, Customer customer1) {
        customer1.setAge(customer.getAge());
        customer1.setEmail(customer.getEmail());
        customer1.setName(customer.getName());
        return customerRepository.save(customer1);
    }
}
