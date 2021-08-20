package com.arul.bankws.repo;


import java.util.Date;
import java.util.List;

import com.arul.bankws.ui.model.response.TransactionResponse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TransactionRepository extends CrudRepository<TransactionResponse, Long>{
    TransactionResponse findById(long id);
    List<TransactionResponse> findByAccID(long id);
    @Query(value = "SELECT * FROM transactions WHERE accID = ?1 AND DAY(DATE) = DAY(?2)", nativeQuery = true)
    List<TransactionResponse> findByAccIDAndDate(long id, Date date);
}
