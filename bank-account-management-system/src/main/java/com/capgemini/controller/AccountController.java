package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.entity.Account;
import com.capgemini.model.service.AccountService;

import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    
    @PostMapping
    public Map<String, Object> createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    
    @GetMapping("/{id}")
    public Object getAccount(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    
    @PutMapping("/{id}")
    public Map<String, String> updateAccount(@PathVariable Integer id,
                                             @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    
    @DeleteMapping("/{id}")
    public Map<String, String> deleteAccount(@PathVariable Integer id) {
        return accountService.deleteAccount(id);
    }

    
    @PostMapping("/deposit")
    public Map<String, Object> deposit(@RequestBody Map<String, Object> body) {

        Integer accountId = Integer.parseInt(body.get("accountId").toString());
        Double amount = Double.parseDouble(body.get("amount").toString());

        return accountService.deposit(accountId, amount);
    }

    
    @PostMapping("/withdraw")
    public Map<String, Object> withdraw(@RequestBody Map<String, Object> body) {

        Integer accountId = Integer.parseInt(body.get("accountId").toString());
        Double amount = Double.parseDouble(body.get("amount").toString());

        return accountService.withdraw(accountId, amount);
    }
}
