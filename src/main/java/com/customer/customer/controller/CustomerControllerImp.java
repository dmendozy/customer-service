package com.customer.customer.controller;

import com.customer.customer.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerControllerImp {
    @Autowired
    CustomerServiceImp customerServiceImp;

}
