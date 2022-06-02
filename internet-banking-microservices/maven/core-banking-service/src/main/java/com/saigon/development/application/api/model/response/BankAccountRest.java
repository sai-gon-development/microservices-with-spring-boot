package com.saigon.development.application.api.model.response;

import java.math.BigDecimal;

import com.saigon.development.application.enums.AccountStatus;
import com.saigon.development.application.enums.AccountType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountRest {

  @Schema(defaultValue = "1", description = "Id")
  private Long id;

  @Schema(defaultValue = "1", description = "number")
  private String number;

  @Schema(defaultValue = "SAVINGS_ACCOUNT", description = "type")
  private AccountType type;

  @Schema(defaultValue = "ACTIVE", description = "status")
  private AccountStatus status;

  @Schema(defaultValue = "1000", description = "availableBalance")
  private BigDecimal availableBalance;

  @Schema(defaultValue = "1000", description = "actualBalance")
  private BigDecimal actualBalance;

}
