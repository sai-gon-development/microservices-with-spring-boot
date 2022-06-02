package com.saigon.development.application.service;

import com.saigon.development.application.api.model.response.UserRest;

public interface AccountService {

  UserRest getBankAccountHATEOAS(String identificationNumber);

}
