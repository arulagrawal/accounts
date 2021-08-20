package com.arul.bankws.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.arul.bankws.repo.AccountRepository;
import com.arul.bankws.repo.TransactionRepository;
import com.arul.bankws.service.TransactionService;
import com.arul.bankws.shared.Type;
import com.arul.bankws.ui.model.request.TransactionRequest;
import com.arul.bankws.ui.model.response.AccountResponse;
import com.arul.bankws.ui.model.response.TransactionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepo;
    private AccountRepository accRepo;

    protected TransactionServiceImpl() {
    };

    @Autowired
    public TransactionServiceImpl(TransactionRepository tRepo, AccountRepository accRepo) {
        this.transactionRepo = tRepo;
        this.accRepo = accRepo;
    }

    private AccountResponse getAccount(long accID) {
        var account = accRepo.findById(accID);
        if (account.isPresent()) return account.get();
        return null;
    }

    @Override
    public TransactionResponse createTransaction(long accID, TransactionRequest request) {
        AccountResponse account = getAccount(accID);
        if (account == null) {
            return null;
        }
        int amount = request.getAmount();
        int balance = account.getBalance();
        if (request.getType() == Type.DEBIT) {
            balance -= amount;
        } else {
            balance += amount;
        }
        account.setBalance(balance);
        accRepo.save(account);
        TransactionResponse transaction = new TransactionResponse(accID, amount,
                request.getType(), request.getDate(), request.getSource(), request.getDescription(), balance);
        transactionRepo.save(transaction);
        return transaction;
    }

    @Override
    public List<TransactionResponse> getStatement(long accID, Date date) {
        var transactions = transactionRepo.findByAccIDAndDate(accID, date);
        List<TransactionResponse> transactionList = new ArrayList<>();
        transactions.forEach(transactionList::add);

        return transactionList;
    }

    @Override
    public List<TransactionResponse> getTransactions(long accID) {
        var transactions = transactionRepo.findByAccID(accID);
        List<TransactionResponse> transactionList = new ArrayList<>();
        transactions.forEach(transactionList::add);

        return transactionList;
    }

}
