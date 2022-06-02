package com.saigon.development.application.service;

import com.saigon.development.application.api.model.response.BankAccount;
import com.saigon.development.application.api.model.response.UserRest;

public interface AccountService {
  BankAccount readBankAccount(String accountNumber);

  UserRest getBankAccountHATEOAS(String identificationNumber);

}
