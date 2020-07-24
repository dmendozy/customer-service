package com.customer.customer.utils;

import com.customer.customer.model.Customer;

import java.util.List;

public class CustomerMapper {
    public static Customer map(List<Customer> customers) {
        Customer customer = new Customer();
        for (Customer c : customers) {
            if (c.getCustomerId() != null) customer.setCustomerId(c.getCustomerId());
            if (c.getEmail() != null) customer.setEmail(c.getEmail());
            if (c.getPhone() != null) customer.setPhone(c.getPhone());
            if (c.getAddress() != null) customer.setAddress(c.getAddress());
            if (c.getList()!=null) customer.setList(c.getList());
           // if (c.getCredits()!=null) customer.setCredits(c.getCredits());
        }
        return customer;
    }

}
