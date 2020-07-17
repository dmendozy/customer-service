package com.customer.customer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    public String customerId;
    public String firstName;
    public String lastName;
    public String documentType;
    public String documentNumber;
    public String address;

    public Customer(){
        super();
    }
}
