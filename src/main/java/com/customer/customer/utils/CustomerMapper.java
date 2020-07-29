package com.customer.customer.utils;

import com.customer.customer.model.Customer;

import java.util.List;

public class CustomerMapper {
    public static Customer map(List<Customer> customers) {
        Customer customer = new Customer();
        for (Customer c : customers) {
            if (c.getCustomerId() != null) customer.setCustomerId(c.getCustomerId());
            if (c.getCustomerCode() != null) customer.setCustomerCode(c.getCustomerCode());
            if (c.getCustomerProfile() != null) customer.setCustomerProfile(c.getCustomerProfile());
            if (c.getName() != null) customer.setName(c.getName());
            if (c.getDocumentType() != null) customer.setDocumentType(c.getDocumentType());
            if (c.getDocumentNumber() != null) customer.setDocumentNumber(c.getDocumentNumber());
            if (c.getEmail() != null) customer.setEmail(c.getEmail());
            if (c.getPhone() != null) customer.setPhone(c.getPhone());
            if (c.getAddress() != null) customer.setAddress(c.getAddress());
            if (c.getAccounts()!=null) customer.setAccounts(c.getAccounts());
            if (c.getCredits()!=null) customer.setCredits(c.getCredits());
            if (c.getBanks()!=null) customer.setBanks(c.getBanks());
        }
        return customer;
    }

}
