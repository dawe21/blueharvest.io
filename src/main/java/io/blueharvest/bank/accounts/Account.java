package io.blueharvest.bank.accounts;

import io.blueharvest.bank.transactions.Transaction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Account {
    private String number;
    private double amount;
    private String customerId;

    private Map<String, Transaction> transactions = new HashMap<>();

    public Account() {}

    public Account(String number, double amount, String customerId) {
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addTransaction(String transactionId, Transaction transaction) {
        transactions.put(transactionId, transaction);

        // Sort the accounts
        transactions = transactions.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<String, Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", amount=" + amount +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}