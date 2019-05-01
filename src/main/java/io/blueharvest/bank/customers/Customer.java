package io.blueharvest.bank.customers;

import io.blueharvest.bank.accounts.Account;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Customer {
   private String customerId = "";
   private String name = "";
   private String sureName = "";

   public Map<String, Account> accounts = new HashMap<>();

   public String getCustomerId() {
      return customerId;
   }

   public void setCustomerId(String customerId) {
      this.customerId = customerId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSureName() {
      return sureName;
   }

   public void setSureName(String sureName) {
      this.sureName = sureName;
   }

   @Override
   public String toString() {
      return "Customer{" +
              "customerId='" + customerId + '\'' +
              ", name='" + name + '\'' +
              ", sureName='" + sureName + '\'' +
              '}';
   }

   public Map<String, Account> getAccounts() {
      return accounts;
   }

   public void addAccount(Account account) {
      getAccounts().put(account.getNumber(), account);

      // Sort the accounts
      accounts = accounts.entrySet().stream()
              .sorted(Map.Entry.comparingByKey())
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                      (oldValue, newValue) -> oldValue, LinkedHashMap::new));
   }
}
