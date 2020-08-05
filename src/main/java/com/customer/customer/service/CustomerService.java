package com.customer.customer.service;

import com.customer.customer.model.Customer;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    public Flux<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Mono<Customer> getById(String id){return customerRepository.findById(id);}

    public Mono update(String id, Customer customer){
        return customerRepository.save(customer);
    }

    public Mono save(Customer customer){
        return customerRepository.save(customer);
    }

    public Mono delete(String id){
        return customerRepository.deleteById(id);
    }

}
