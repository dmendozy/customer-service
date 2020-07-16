package com.customer.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("customers")
public class Customer {

    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String dni;
    public String address;

    public Customer(){
        super();
    }
}
