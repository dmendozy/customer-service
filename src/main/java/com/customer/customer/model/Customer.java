package com.customer.customer.model;

import com.customer.customer.adds.Account;
import com.customer.customer.adds.Credit;
import com.customer.customer.adds.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    public String customerId;
    public String email;
    public String phone;
    public String address;

    public Customer(){
        super();
    }

    public Customer(String customerId, String email, String phone, String address) {
        this.customerId = customerId;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Transient
    public Account account;
    @Transient
    public Credit credit;
    @Transient
    public Transaction transaction;

}
