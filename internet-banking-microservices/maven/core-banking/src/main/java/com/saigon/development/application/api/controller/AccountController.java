package com.saigon.development.application.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saigon.development.application.api.model.response.BankAccount;
import com.saigon.development.application.api.model.response.BankAccountRest;
import com.saigon.development.application.api.model.response.UserRest;
import com.saigon.development.application.service.AccountService;
import com.saigon.development.application.service.BankAccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/account")
public class AccountController {

  @Autowired
  AccountService accountService;

  @Autowired
  BankAccountService bankAccountService;

  @GetMapping("/bank-account/{accountNumber}")
  public ResponseEntity<BankAccount> getBankAccount(
      @PathVariable("accountNumber") String accountNumber) {
    log.info("Reading account by ID {}", accountNumber);

    return new ResponseEntity<>(
        bankAccountService.readBankAccount(accountNumber),
        HttpStatus.OK);
  }

  @GetMapping("/bank-account/{identificationNumber}/hateoas")
  public UserRest getUserRestHATEOAS(@PathVariable("identificationNumber") String identificationNumber) {
    log.info("Reading account by ID {}", identificationNumber);
    UserRest userRest = accountService.getBankAccountHATEOAS(identificationNumber);

    Link userResourceLink = WebMvcLinkBuilder.linkTo(AccountController.class).slash(userRest.getId()).withSelfRel();
    Link bankAccountResourceLink = WebMvcLinkBuilder.linkTo(AccountController.class).slash(userRest.getId())
        .slash("listBankAccount")
        .withRel("listBankAccount");

    userRest.add(userResourceLink);
    userRest.add(bankAccountResourceLink);

    return userRest;
  }

  @GetMapping("{id}/listBankAccount")
  public BankAccountRest listBankAccount(@PathVariable("id") long id) {
    log.info("List bank account by ID {}", id);
    return null;
  }

}
