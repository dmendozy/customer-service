package com.customer.customer.controller;

import com.customer.customer.model.Customer;
import com.customer.customer.repository.CustomerRepository;
import com.customer.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CustomerController.class)
@Import(CustomerService.class)
public class CustomerControllerTest {

    @MockBean
    CustomerRepository repository;

    @Autowired
    private WebTestClient webClient;

    private static Map<String, Customer> customerMap = new HashMap<>();


    @BeforeAll
    public static void setup(){
        //customerMap.put("test",new Customer("1","Danny","Mendoza Yenque","DNI","70673131","Ancon"));
    }

    @Test
    public void testCreateCustomer(){
        Mockito
                .when(repository.save(customerMap.get("test"))).thenReturn(Mono.just(customerMap.get("test")));

        webClient.post()
                .uri("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customerMap.get("test")))
                .exchange()
                .expectStatus().isOk();
        Mockito.verify(repository,Mockito.times(1)).save(customerMap.get("test"));

    }


    @Test
    public void testGetCustomerById(){
        Mockito
                .when(repository.findById(customerMap.get("test").customerId))
                .thenReturn(Mono.just(customerMap.get("test")));

        webClient.get()
                .uri("/customers/{id}",customerMap.get("test").customerId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .isEqualTo(customerMap.get("test"));
        Mockito.verify(repository, Mockito.times(1)).findById(customerMap.get("test").customerId);
    }

    @Test
    public void testUpdateCustomer(){
        Mockito
                .when(repository.findById(customerMap.get("test").customerId))
                .thenReturn(Mono.just(customerMap.get("test")));

        webClient.put()
                .uri("/customers/{id}",customerMap.get("test").customerId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customerMap.get("test")))
                .exchange()
                .expectStatus().isOk();
        Mockito.verify(repository,Mockito.times(1)).save(customerMap.get("test"));
    }

    @Test
    public void testDeleteCustomer(){
        Mockito
                .when(repository.deleteById(customerMap.get("test").customerId))
                .thenReturn(Mono.empty());

        webClient.delete()
                .uri("/customers/{id}",customerMap.get("test").customerId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .isEqualTo(null);
        Mockito.verify(repository, Mockito.times(1)).deleteById(customerMap.get("test").customerId);

    }
}
