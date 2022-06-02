package com.saigon.development.application.api.model.response;

import java.util.List;

import lombok.Data;

@Data
public class User {

  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String identificationNumber;

  private List<BankAccount> listBankAccount;
}
