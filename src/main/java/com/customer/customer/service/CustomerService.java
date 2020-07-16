package com.customer.customer.service;

import com.customer.customer.model.Customer;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Flux<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Mono<Customer> getById(String id){
        return customerRepository.findById(id);
    }

    public Mono<Customer> save(Customer customer){
        return customerRepository.save(customer);
    }

    public Mono<Customer> update(String id,Customer customer){
        return customerRepository.save(customer);
    }

    public Mono delete(String id){
        return customerRepository.deleteById(id);
    }
}
