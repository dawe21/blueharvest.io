package io.blueharvest.bank.accounts;

import io.blueharvest.bank.transactions.Transaction;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
   String number;
   double amount;
   String customerId;
   Account account;

   @org.junit.jupiter.api.BeforeEach
   void setUp() {
      number = "0";
      amount = 10;
      customerId = "0";
      account = new Account(number, amount, customerId);
   }

   @org.junit.jupiter.api.AfterEach
   void tearDown() {

   }

   @org.junit.jupiter.api.Test
   void getNumber() {
      assertTrue(number==account.getNumber());
   }

   @org.junit.jupiter.api.Test
   void setNumber() {
      account.setNumber(number);
      assertTrue(number==account.getNumber());
   }

   @org.junit.jupiter.api.Test
   void getCustomerId() {
   }

   @org.junit.jupiter.api.Test
   void setCustomerId() {
   }

   @org.junit.jupiter.api.Test
   void getAmount() {
   }

   @org.junit.jupiter.api.Test
   void setAmount() {
   }

   @org.junit.jupiter.api.Test
   void addTransaction() {
   }

   @org.junit.jupiter.api.Test
   void getTransactions() {
   }
}