package com.saigon.development.application.service.impl;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saigon.development.application.api.model.response.BankAccount;
import com.saigon.development.application.api.model.response.User;
import com.saigon.development.application.io.entity.BankAccountEntity;
import com.saigon.development.application.io.entity.UserEntity;
import com.saigon.development.application.io.repository.BankAccountRepository;
import com.saigon.development.application.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

  ModelMapper modelMapper = new ModelMapper();

  @Autowired
  BankAccountRepository bankAccountRepository;

  @Override
  public BankAccount readBankAccount(String accountNumber) {
    User user = new User();
    BankAccount bankAccount = new BankAccount();

    BankAccountEntity bankAccountEntity = bankAccountRepository
        .findByNumber(accountNumber)
        .orElseThrow(EntityNotFoundException::new);

    log.info("Banking Account Entity: {}", bankAccountEntity);

    UserEntity userEntity = bankAccountEntity.getUser();
    BeanUtils.copyProperties(userEntity, user);
    BeanUtils.copyProperties(bankAccountEntity, bankAccount);

    bankAccount.setUser(user);

    return bankAccount;
  }
}
