package com.jeimseu.controller;

import com.jeimseu.model.Customer;
import com.jeimseu.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerEndpoint {

    private final CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save/customer")
    public ResponseEntity<Customer> persistCustomerInfo(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/fetch/customer")
    public List<Customer> fetchAllCustomerInfo(){
        return customerService.fetchAllCustomerInfo();
    }
}
