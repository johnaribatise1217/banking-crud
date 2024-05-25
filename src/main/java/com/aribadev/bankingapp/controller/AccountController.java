package com.aribadev.bankingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aribadev.bankingapp.models.AccountDetails;
import com.aribadev.bankingapp.service.implementation.AccountServiceImplementation;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
  @Autowired
  private AccountServiceImplementation accountService;

  @PostMapping
  public ResponseEntity<AccountDetails> createAccount(@RequestBody AccountDetails accountDetails){
    return new ResponseEntity<>(accountService.createAccount(accountDetails), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountDetails> getAccountById(@PathVariable Long id){
    return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.FOUND);
  }

  @PutMapping("/{id}/deposit")
  public ResponseEntity<AccountDetails> deposit(@PathVariable Long id,
    @RequestBody Map<String, Double> request
  ){
    Double amount = request.get("amount");
    return new ResponseEntity<>(accountService.deposit(id, amount),HttpStatus.OK);
  }

  @PutMapping("/{id}/withdraw")
  public ResponseEntity<AccountDetails> withdraw(@PathVariable Long id,
    @RequestBody Map<String, Double> request
  ){
    Double amount = request.get("amount");
    return new ResponseEntity<>(accountService.withdraw(id, amount),HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<AccountDetails>> getAllAccounts(){
    return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAccount(@PathVariable Long id){
    return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
  }
}
