package com.customer.customer.controller;

import com.customer.customer.model.Customer;
import com.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public Flux<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Customer> getCustomerById(@PathVariable("id") String customerId){
        return customerService.getById(customerId);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@Validated @RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("{id}")
    public Mono<Customer> updateCustomer(@PathVariable("id") String customerId,
                                         @Validated @RequestBody Customer customer){
        return customerService.update(customerId, customer);
    }

    @DeleteMapping("{id}")
    public Mono<Customer> deleteCustomer(@PathVariable("id") String customerId){
        return customerService.delete(customerId);
    }

}
