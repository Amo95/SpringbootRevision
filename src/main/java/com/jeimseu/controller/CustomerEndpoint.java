package com.jeimseu.controller;

import com.jeimseu.model.Customer;
import com.jeimseu.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerEndpoint {

    private final CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer persistCustomerInfo(@RequestBody Customer customer){
        return customerService.persistUserData(customer);
    }

    @GetMapping("/fetch/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> fetchAllCustomerInfo(){
        return customerService.fetchAllCustomersInfo();
    }

    @GetMapping("/fetch/customer/")
    @ResponseStatus(HttpStatus.OK)
    public Customer fetchCustomerById(@RequestParam Long id){
        return customerService.fetchAllCustomerInfoById(id);
    }

    @DeleteMapping("/delete/customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteCustomer(@RequestParam Long id){
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/update/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer updateCustomer(@RequestParam Long id, @RequestBody Customer customer){
        return customerService.updateCustomerInfoById(id, customer);
    }
}
