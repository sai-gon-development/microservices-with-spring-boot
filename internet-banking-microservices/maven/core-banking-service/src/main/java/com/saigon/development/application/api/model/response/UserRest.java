package com.saigon.development.application.api.model.response;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRest extends RepresentationModel<UserRest> {

  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String identificationNumber;

  private List<BankAccount> listBankAccount;

}
