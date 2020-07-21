package com.customer.customer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "businesspyme")
public class CustomerPYME extends Customer {
    public String ruc;
    public String name;

    public CustomerPYME(String ruc, String name){
        super();
        this.ruc=ruc;
        this.name=name;
    }

}
