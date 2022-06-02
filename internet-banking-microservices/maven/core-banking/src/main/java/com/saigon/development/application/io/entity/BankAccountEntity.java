package com.saigon.development.application.io.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.saigon.development.application.enums.AccountStatus;
import com.saigon.development.application.enums.AccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "banking_core_account")
public class BankAccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String number;

  @Enumerated(EnumType.STRING)
  private AccountType type;

  @Enumerated(EnumType.STRING)
  private AccountStatus status;

  private BigDecimal availableBalance;

  private BigDecimal actualBalance;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
}
