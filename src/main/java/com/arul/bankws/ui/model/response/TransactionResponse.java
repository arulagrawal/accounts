package com.arul.bankws.ui.model.response;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.arul.bankws.shared.Type;

@Entity
@Table(name = "transactions")
public class TransactionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;
    private long accID;
    private int amount;
    private Type type;
    private Date date;
    private String source;
    private String description;
    private int balance;

    public TransactionResponse(long accID, int amount, Type type, Date date, String source,
        String description, int balance) {
        this.accID = accID;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.source = source;
        this.description = description;
        this.balance = balance;
    }
    protected TransactionResponse() {}

    public int getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    public long getAccID() {
        return accID;
    }
    public void setAccID(int accID) {
        this.accID = accID;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

}