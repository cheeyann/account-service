package com.example.account;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public Account findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
    }

    public Account create(String name, String email, BigDecimal balance) {
        return repository.save(new Account(name, email, balance));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
