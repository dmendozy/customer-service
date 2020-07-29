package com.customer.customer.model;

import com.customer.customer.adds.Account;
import com.customer.customer.adds.Bank;
import com.customer.customer.adds.Credit;
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
    public String customerCode;
    public String customerProfile;
    public String name;
    public String documentType;
    public String documentNumber;
    public String email;
    public String phone;
    public String address;
    @Transient
    public List<Account> accounts;
    @Transient
    public List<Credit> credits;
    @Transient
    public List<Bank> banks;

    public Customer(){
        super();
    }


    public Customer(String customerId, String customerCode, String customerProfile, String name, String documentType, String documentNumber, String email, String phone, String address) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerProfile = customerProfile;
        this.name = name;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


    public Customer(List<Account> accounts, List<Credit> credits) {
        this.accounts=accounts;
        this.credits=credits;
    }

    public Customer(Customer customer, List<Bank> banks) {
        this(customer.getAccounts(),customer.getCredits());
        this.banks=banks;
    }
}
