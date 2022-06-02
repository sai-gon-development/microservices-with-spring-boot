package com.saigon.development.application.api.model.response;

import java.math.BigDecimal;

import com.saigon.development.application.enums.AccountStatus;
import com.saigon.development.application.enums.AccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {

  private Long id;

  private String number;

  private AccountType type;

  private AccountStatus status;

  private BigDecimal availableBalance;

  private BigDecimal actualBalance;
}
