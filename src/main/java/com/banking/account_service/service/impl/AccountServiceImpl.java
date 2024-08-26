package com.banking.account_service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking.account_service.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private final WebClient webClient;

    public AccountServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @Override
    public String getBalanceFromBalanceService() {
        return webClient.get()
                        .uri("/balance/get-balance")
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
    }
}
