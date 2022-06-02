package com.saigon.development.application.api.model.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class User {

  @Schema(defaultValue = "1", description = "id")
  private Long id;

  @Schema(defaultValue = "Richard", description = "firstName")
  private String firstName;

  @Schema(defaultValue = "Vu", description = "lastName")
  private String lastName;

  @Schema(defaultValue = "richardvu.dev@gmail.com", description = "email")
  private String email;

  @Schema(defaultValue = "999999999V", description = "identificationNumber")
  private String identificationNumber;

  @Schema(description = "listBankAccount")
  private List<BankAccount> listBankAccount;

}
