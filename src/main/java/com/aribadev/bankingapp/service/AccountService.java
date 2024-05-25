package com.aribadev.bankingapp.service;

import java.util.List;

import com.aribadev.bankingapp.models.AccountDetails;

public interface AccountService {
  AccountDetails createAccount(AccountDetails account);

  AccountDetails getAccountById(Long id);

  AccountDetails deposit(Long id, double amount);

  AccountDetails withdraw(Long id, double amount);

  List<AccountDetails> getAllAccounts();

  String deleteAccount(Long id);
}
