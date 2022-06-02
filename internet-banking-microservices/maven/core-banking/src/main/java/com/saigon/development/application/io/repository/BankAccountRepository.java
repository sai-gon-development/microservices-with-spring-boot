package com.saigon.development.application.io.repository;

import com.saigon.development.application.io.entity.BankAccountEntity;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankAccountRepository
  extends PagingAndSortingRepository<BankAccountEntity, Long> {
  Optional<BankAccountEntity> findByNumber(String accountNumber);
}
