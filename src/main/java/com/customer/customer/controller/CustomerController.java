package com.customer.customer.controller;

import com.customer.customer.adds.Account;
import com.customer.customer.model.Customer;
import com.customer.customer.service.CustomerService;
import com.customer.customer.utils.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    WebClient.Builder webClientBuilder;

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

    @GetMapping("/{id}/withaccounts")
    public Mono<Customer> findByIdWithAccounts(@PathVariable("id") String id) {
        Flux<Account> accounts = webClientBuilder.build().get().uri("http://account-service/accounts/customer/{customer}",id).retrieve().bodyToFlux(Account.class);
        return accounts
                .collectList()
                .map(a -> new Customer(a))
                .mergeWith(customerService.getById(id))
                .collectList()
                .map(CustomerMapper::map);
    }




}
