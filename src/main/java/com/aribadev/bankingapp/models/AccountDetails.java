package com.aribadev.bankingapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDetails {
  private Long id;
  private String accountHolderName;
  private double balance;
}
