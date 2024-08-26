package com.banking.account_service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking.account_service.service.AccountService;
import com.banking.account_service.util.ConstantUtils;

@Service
public class AccountServiceImpl implements AccountService {

    private final WebClient webClient;

    public AccountServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(ConstantUtils.balanceBaseUrl).build();
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
