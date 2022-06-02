package com.saigon.development.application.api.model.response;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRest extends RepresentationModel<UserRest> {

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

}
