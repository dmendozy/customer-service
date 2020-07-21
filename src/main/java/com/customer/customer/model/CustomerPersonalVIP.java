package com.customer.customer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "personalvip")
public class CustomerPersonalVIP extends Customer {
    public String dni;
    public String firstName;
    public String lastName;

    public CustomerPersonalVIP(String dni, String firstName, String lastName){
        super();
        this.dni=dni;
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
