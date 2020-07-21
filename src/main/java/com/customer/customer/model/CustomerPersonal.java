package com.customer.customer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "personal")
public class CustomerPersonal extends Customer {

    public String dni;
    public String firstName;
    public String lastName;

    public CustomerPersonal(String dni, String firstName, String lastName){
        super();
        this.dni=dni;
        this.firstName=firstName;
        this.lastName=lastName;
    }

}
