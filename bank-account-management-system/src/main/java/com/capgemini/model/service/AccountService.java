package com.capgemini.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Account;
import com.capgemini.model.repository.AccountRepository;

import java.util.*;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Map<String, Object> createAccount(Account account) {

        if (account.getBalance() < 0) {
            return Map.of("message", "Balance cannot be negative");
        }

        Account saved = accountRepository.save(account);

        return Map.of(
                "message", "Account created successfully",
                "accountId", saved.getId()
        );
    }


    public Object getAccountById(Integer id) {
        Optional<Account> optional = accountRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Account not found");
        }

        return optional.get();
    }


    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    public Map<String, String> updateAccount(Integer id, Account updatedAccount) {

        Optional<Account> optional = accountRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Account not found");
        }

        if (updatedAccount.getBalance() < 0) {
            return Map.of("message", "Balance cannot be negative");
        }

        Account existing = optional.get();

        existing.setAccountHolderName(updatedAccount.getAccountHolderName());
        existing.setBalance(updatedAccount.getBalance());

        accountRepository.save(existing);

        return Map.of("message", "Account updated successfully");
    }


    public Map<String, String> deleteAccount(Integer id) {

        Optional<Account> optional = accountRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Account not found");
        }

        accountRepository.deleteById(id);

        return Map.of("message", "Account deleted successfully");
    }


    public Map<String, Object> deposit(Integer accountId, Double amount) {

        Optional<Account> optional = accountRepository.findById(accountId);

        if (optional.isEmpty()) {
            return Map.of("message", "Account not found");
        }

        if (amount <= 0) {
            return Map.of("message", "Invalid amount");
        }

        Account account = optional.get();

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);

        return Map.of(
                "message", "Deposit successful",
                "updatedBalance", account.getBalance()
        );
    }


    public Map<String, Object> withdraw(Integer accountId, Double amount) {

        Optional<Account> optional = accountRepository.findById(accountId);

        if (optional.isEmpty()) {
            return Map.of("message", "Account not found");
        }

        if (amount <= 0) {
            return Map.of("message", "Invalid amount");
        }

        Account account = optional.get();

        if (account.getBalance() < amount) {
            return Map.of("message", "Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);

        return Map.of(
                "message", "Withdrawal successful",
                "updatedBalance", account.getBalance()
        );
    }
}
