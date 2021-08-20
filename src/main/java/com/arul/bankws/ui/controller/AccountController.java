package com.arul.bankws.ui.controller;

import java.util.Date;
import java.util.List;

import com.arul.bankws.service.impl.AccountServiceImpl;
import com.arul.bankws.service.impl.TransactionServiceImpl;
import com.arul.bankws.ui.model.request.AccountRequest;
import com.arul.bankws.ui.model.request.TransactionRequest;
import com.arul.bankws.ui.model.response.AccountResponse;
import com.arul.bankws.ui.model.response.TransactionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;
    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        var accounts = accountService.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(path="/{accountID}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountResponse> getAccount(@PathVariable int accountID) {
        AccountResponse account = accountService.getAccount(accountID);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping(path="/{accountID}/transactions", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TransactionResponse>> getTransactions(@PathVariable int accountID, @RequestParam(value = "date", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        if (date == null) {
            return new ResponseEntity<>(transactionService.getTransactions(accountID), HttpStatus.OK);
        }
        return new ResponseEntity<>(transactionService.getStatement(accountID, date), HttpStatus.OK);
    }

    @PostMapping(path="/{accountID}/transactions", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TransactionResponse> createTransaction(@PathVariable long accountID, @RequestBody TransactionRequest transactionDetails) {
        TransactionResponse transaction = transactionService.createTransaction(accountID, transactionDetails);
        if (transaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountDetails) {
        AccountResponse account = accountService.createAccount(accountDetails);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }


}