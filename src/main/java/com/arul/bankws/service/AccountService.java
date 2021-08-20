package com.arul.bankws.service;

import java.util.List;

import com.arul.bankws.ui.model.request.AccountRequest;
import com.arul.bankws.ui.model.response.AccountResponse;

public interface AccountService {
    AccountResponse createAccount(AccountRequest request);

    List<AccountResponse> getAccounts();
    AccountResponse getAccount(long accID);
}
