package com.aribadev.bankingapp.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aribadev.bankingapp.models.Account;
import com.aribadev.bankingapp.models.AccountDetails;
import com.aribadev.bankingapp.models.AccountMapper;
import com.aribadev.bankingapp.repository.AccountRepository;
import com.aribadev.bankingapp.service.AccountService;

@Service
public class AccountServiceImplementation implements AccountService{
  private final AccountRepository accountRepository;

  public AccountServiceImplementation(AccountRepository accountRepository){
    this.accountRepository = accountRepository;
  }
  @Override
  public AccountDetails createAccount(AccountDetails accountD) {
    Account account = AccountMapper.mapToAccount(accountD);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccountDetails(savedAccount);
  }

  @Override
  public AccountDetails getAccountById(Long id) {
    Account account = accountRepository.findById(id).orElseThrow(
      () -> new RuntimeException("Account does not exist")
    );
    return AccountMapper.mapToAccountDetails(account);
  }

  @Override
  public AccountDetails deposit(Long id, double amount) {
    Account account = accountRepository.findById(id).orElseThrow(
      () -> new RuntimeException("Account does not exist")
    );

    double newAccountBalance = account.getBalance() + amount;
    account.setBalance(newAccountBalance);
    Account savedAccount = accountRepository.save(account);

    return AccountMapper.mapToAccountDetails(savedAccount);
  }

  @Override
  public AccountDetails withdraw(Long id, double amount) {
    Account account = accountRepository.findById(id).orElseThrow(
      () -> new RuntimeException("Account does not exist")
    );

    if(account.getBalance() < amount){
      throw new RuntimeException("Insufficient balance, withdraw failed");
    }

    double newAccountBalance = account.getBalance() - amount;
    account.setBalance(newAccountBalance);
    Account savedAccount = accountRepository.save(account);

    return AccountMapper.mapToAccountDetails(savedAccount);
  }
  @Override
  public List<AccountDetails> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return accounts.stream().map((account) -> AccountMapper.mapToAccountDetails(account))
      .collect(Collectors.toList());
  }

  @Override
  public String deleteAccount(Long id) {
    Account account = accountRepository.findById(id).orElseThrow(
      () -> new RuntimeException("Account does not exist")
    );
    accountRepository.delete(account);

    return "Account has been deleted successfully";
  }

}
