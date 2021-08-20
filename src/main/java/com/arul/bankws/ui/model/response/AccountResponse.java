package com.arul.bankws.ui.model.response;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accID;
    private String firstName;
    private String lastName;
    private int balance;

    public AccountResponse(String firstName, String lastName, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    protected AccountResponse() {}

    public long getAccID() {
        return accID;
    }

    public void setAccID(long accID) {
        this.accID = accID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    };

}
