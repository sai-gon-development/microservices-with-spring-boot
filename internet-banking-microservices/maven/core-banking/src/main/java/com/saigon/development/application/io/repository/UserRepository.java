package com.saigon.development.application.io.repository;

import com.saigon.development.application.io.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
    extends PagingAndSortingRepository<UserEntity, Long> {

  Optional<UserEntity> findByIdentificationNumber(String identificationNumber);

}
