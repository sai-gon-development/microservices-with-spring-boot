package com.saigon.development.application.service.impl;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saigon.development.application.api.model.response.BankAccount;
import com.saigon.development.application.api.model.response.BankAccountRest;
import com.saigon.development.application.api.model.response.User;
import com.saigon.development.application.api.model.response.UserRest;
import com.saigon.development.application.io.entity.BankAccountEntity;
import com.saigon.development.application.io.entity.UserEntity;
import com.saigon.development.application.io.repository.BankAccountRepository;
import com.saigon.development.application.io.repository.UserRepository;
import com.saigon.development.application.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

  ModelMapper modelMapper = new ModelMapper();

  @Autowired
  UserRepository userRepository;

  @Override
  public UserRest getBankAccountHATEOAS(String identificationNumber) {
    UserRest userRest = new UserRest();

    UserEntity userEntity = userRepository.findByIdentificationNumber(identificationNumber)
        .orElseThrow(EntityNotFoundException::new);

    log.info("User Entity: {}", userEntity);
    BeanUtils.copyProperties(userEntity, userRest);

    return userRest;
  }

}
