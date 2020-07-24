package com.customer.customer.model;

import com.customer.customer.adds.Account;
import com.customer.customer.adds.Credit;
import com.customer.customer.adds.Transaction;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    public String customerId;
    public String email;
    public String phone;
    public String address;
    public String customerProfile;
    @Transient
    public List list;

    public Customer(){
        super();
    }



    public Customer(String customerId, String email, String phone, String address, String customerProfile) {
        this.customerId = customerId;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.customerProfile = customerProfile;
    }

    public Customer(List list) {
        this.list = list;
    }


    /*
    public Customer (List<Account> accounts, List<Credit> credits) {
        this.accounts = accounts;
        this.credits = credits;
    }

    public Customer(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Customer(List<Credit> credits) {
        this.credits = credits;
    }


    @Transient
    public Transaction transaction;*/

}
