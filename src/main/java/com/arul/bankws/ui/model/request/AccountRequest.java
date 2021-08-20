package com.arul.bankws.ui.model.request;

public class AccountRequest {
    private final String firstName;
    private final String lastName;

    public AccountRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
