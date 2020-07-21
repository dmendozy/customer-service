package com.customer.customer.service;

import com.customer.customer.client.AccountClient;
import com.customer.customer.client.CreditClient;
import com.customer.customer.client.TransactionClient;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
