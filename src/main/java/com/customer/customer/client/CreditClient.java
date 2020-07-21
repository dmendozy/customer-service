package com.customer.customer.client;

import com.customer.customer.adds.Credit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient(name = "credit-service")
@RequestMapping("/credits")
public interface CreditClient {
    @GetMapping
    public Flux<Credit> getAllCredits();
    @GetMapping("{id}")
    public Mono<Credit> getCreditById(@PathVariable("id") String accountId);
}
