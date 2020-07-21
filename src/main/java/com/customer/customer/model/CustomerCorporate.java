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
@Document(collection = "businesscorporate")
public class CustomerCorporate extends Customer {
    public String ruc;
    public String name;

    public CustomerCorporate(String ruc, String name){
        super();
        this.ruc=ruc;
        this.name=name;
    }
}
