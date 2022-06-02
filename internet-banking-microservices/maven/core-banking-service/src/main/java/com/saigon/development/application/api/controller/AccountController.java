package com.saigon.development.application.api.controller;

import com.saigon.development.application.api.model.response.BankAccount;
import com.saigon.development.application.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/account")
public class AccountController {

  @Autowired
  AccountService accountService;

  @GetMapping("/bank-account/{account_number}")
  public ResponseEntity<BankAccount> getBankAccount(
      @PathVariable("account_number") String accountNumber) {
    log.info("Reading account by ID {}", accountNumber);

    return new ResponseEntity<>(
        accountService.readBankAccount(accountNumber),
        HttpStatus.OK);
  }

}
