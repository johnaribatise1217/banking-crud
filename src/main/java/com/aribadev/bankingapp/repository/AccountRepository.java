package com.aribadev.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aribadev.bankingapp.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
