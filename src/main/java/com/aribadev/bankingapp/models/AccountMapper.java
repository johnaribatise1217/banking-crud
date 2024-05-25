package com.aribadev.bankingapp.models;

public class AccountMapper {
  public static Account mapToAccount(AccountDetails accountDetails){
    Account account = new Account(
      accountDetails.getId(),
      accountDetails.getAccountHolderName(),
      accountDetails.getBalance()
    );
    return account;
  }

  public static AccountDetails mapToAccountDetails(Account account){
    AccountDetails accountDetails = new AccountDetails(
      account.getId(),
      account.getAccountHolder(),
      account.getBalance()
    );

    return accountDetails;
  }
}
