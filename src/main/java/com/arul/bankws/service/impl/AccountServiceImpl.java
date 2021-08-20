package com.arul.bankws.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.arul.bankws.repo.AccountRepository;
import com.arul.bankws.service.AccountService;
import com.arul.bankws.ui.model.request.AccountRequest;
import com.arul.bankws.ui.model.response.AccountResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository repo;

    protected AccountServiceImpl () {}

    @Autowired
    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public AccountResponse createAccount(AccountRequest request) {
        AccountResponse account = new AccountResponse(request.getFirstName(), request.getLastName(), 0);
        repo.save(account);
        return account;
    }

    @Override
    public AccountResponse getAccount(long accID) {
        var account = repo.findById(accID);
        if (account.isPresent()) return account.get();
        return null;
    }

    @Override
    public List<AccountResponse> getAccounts() {
        var accounts = repo.findAll();
        List<AccountResponse> accList = new ArrayList<>();
        accounts.forEach(accList::add);

        return accList;
    }
}
