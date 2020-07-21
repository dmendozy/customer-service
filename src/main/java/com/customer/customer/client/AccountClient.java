package com.customer.customer.client;

import com.customer.customer.adds.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient(name = "account-service")
@RequestMapping("/accounts")
public interface AccountClient {
    @GetMapping
    public Flux<Account> getAllAccounts();
    @GetMapping("{id}")
    public Mono<Account> getAccountById(@PathVariable("id") String accountId);
}
