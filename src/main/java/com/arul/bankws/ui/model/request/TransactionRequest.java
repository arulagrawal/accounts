package com.arul.bankws.ui.model.request;

import java.util.Date;

import com.arul.bankws.shared.Type;

public class TransactionRequest {
    private int amount;
    private Type type;
    private Date date;
    private String source;
    private String description;

    public TransactionRequest(int amount, Type type, Date date, String source, String description,
            int balance) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.source = source;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }
}
