package com.example.account;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<Account> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Map<String, Object> body) {
        String name = (String) body.get("name");
        String email = (String) body.get("email");
        BigDecimal balance = new BigDecimal(body.get("balance").toString());
        return service.create(name, email, balance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
