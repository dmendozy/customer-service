package com.customer.customer.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Builder
@Document(collection = "business")
public class CustomerBusiness extends Customer{

    public String ruc;
    public String name;

    public CustomerBusiness(String ruc, String name){
        super();
        this.ruc=ruc;
        this.name=name;
    }
}
