package com.customer.customer.service;

import com.customer.customer.adds.Account;
import com.customer.customer.client.AccountClient;
import com.customer.customer.client.CreditClient;
import com.customer.customer.client.TransactionClient;
import com.customer.customer.model.Customer;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImp {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountClient accountClient;
    @Autowired
    CreditClient creditClient;
    @Autowired
    TransactionClient transactionClient;

    /*public Customer getCustomerAccounts(String id){
        Mono<Customer> customer= customerRepository.findById(id);
        if (null != customer){
            Flux<Account> account = accountClient.getAccountById(customer.flatMap(c->c.getCustomerId().equals(id)instanceof Mono).toString());

        }
    }*/
}
