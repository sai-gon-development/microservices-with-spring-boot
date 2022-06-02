package com.saigon.development.application.responses;

import java.io.Serializable;
import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author richard
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

  private static final long serialVersionUID = 1L;

  @Schema(description = "timetamp")
  private ZonedDateTime timetamp;

  @Schema(description = "messages")
  private Object messages;

}