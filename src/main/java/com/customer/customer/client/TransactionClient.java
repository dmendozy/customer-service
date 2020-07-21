package com.customer.customer.client;

import com.customer.customer.adds.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient(name = "transaction-service")
@RequestMapping("/transactions")
public interface TransactionClient {
    @GetMapping
    public Flux<Transaction> getAllTransactions();
    @GetMapping("{id}")
    public Mono<Transaction> getTransactionById(@PathVariable("id") String transactionId);
}
