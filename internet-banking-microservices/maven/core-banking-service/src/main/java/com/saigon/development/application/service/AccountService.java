package com.saigon.development.application.service;

import com.saigon.development.application.api.model.response.BankAccount;

public interface AccountService {
  BankAccount readBankAccount(String accountNumber);
}
