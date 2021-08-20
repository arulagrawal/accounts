package com.arul.bankws.service;

import java.util.Date;
import java.util.List;

import com.arul.bankws.ui.model.request.TransactionRequest;
import com.arul.bankws.ui.model.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse createTransaction(long accID, TransactionRequest request);

    List<TransactionResponse> getTransactions(long accID);
    List<TransactionResponse> getStatement(long accID, Date date);
}
