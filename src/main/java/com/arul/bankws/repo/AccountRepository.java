package com.arul.bankws.repo;

import java.util.Optional;

import com.arul.bankws.ui.model.response.AccountResponse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountRepository extends CrudRepository<AccountResponse, Long>{
    Optional<AccountResponse> findById(long id);
}
