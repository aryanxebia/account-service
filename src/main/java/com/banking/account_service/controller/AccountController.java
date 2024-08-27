package com.banking.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.account_service.service.AccountService;

@RestController
@RequestMapping("/api/v1/")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("balance-countries")
    public ResponseEntity<String> getAccountBalance() {
        String balance = accountService.getBalanceFromBalanceService();
        return ResponseEntity.ok(balance);
        

    }
}
