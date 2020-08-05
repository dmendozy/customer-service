package com.customer.customer.controller;

import com.customer.customer.adds.Account;
import com.customer.customer.adds.Bank;
import com.customer.customer.adds.Credit;
import com.customer.customer.model.Customer;
import com.customer.customer.service.CustomerService;
import com.customer.customer.utils.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public Flux<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Customer> getCustomerById(@PathVariable("id") String customerId) {
        return customerService.getById(customerId);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@Validated @RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("{id}")
    public Mono<Customer> updateCustomer(@PathVariable("id") String customerId,
                                         @Validated @RequestBody Customer customer) {
        return customerService.update(customerId, customer);
    }

    @DeleteMapping("{id}")
    public Mono<Customer> deleteCustomer(@PathVariable("id") String customerId) {
        return customerService.delete(customerId);
    }


    @GetMapping("/profile/{id}")
    public Mono<Customer> findCustomerProfile(@PathVariable("id") String id) {
        Flux<Account> accounts = webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8080/accounts/customer/{customer}", id)
                .retrieve()
                .bodyToFlux(Account.class);
        Flux<Credit> credits = webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8080/credits/customer/{customer}", id)
                .retrieve()
                .bodyToFlux(Credit.class);
        Flux<Bank> banks = webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8080/banks/customer/{customer}", id)
                .retrieve()
                .bodyToFlux(Bank.class);
        Mono<Customer> pre = accounts.collectList().zipWith(credits.collectList(), Customer::new);
        Mono<Customer> mono = pre.zipWith(banks.collectList(), Customer::new);
        return mono
                .mergeWith(customerService.getById(id))
                .collectList()
                .map(CustomerMapper::map);
    }


}
