package io.blueharvest.bank.transactions;

import io.blueharvest.bank.accounts.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class TransactionService {
   /**
    * CustomerService is a Singelton
    * We only want one instance of the CustomerService.
    */
   private TransactionService() {
   }

   private static TransactionService transactionService = null;

   private static Map<String, Transaction> transactions = new HashMap<>();
   private static final AtomicInteger transactionCount = new AtomicInteger();

   public Transaction createTransaction(double newAmount, Account account) {

      double previousAmount = account.getAmount();
      account.setAmount(newAmount);

      String transactionId = nextTransactionId();
      double transactionAmount = newAmount - previousAmount;
      Transaction transaction = new Transaction(transactionId, account.getNumber(), transactionAmount);
      transactions.put(transactionId, transaction);
      account.addTransaction(transactionId, transaction);
      return transaction;
   }

   public String nextTransactionId() {
      return transactionCount.getAndIncrement() + "";
   }

   /**
    * TransactionService
    * @return TransactionService
    */
   public static TransactionService instance() {
      if (transactionService == null) {
         transactionService = new TransactionService();
      }
      return transactionService;
   }

   public Transaction findById(String tid) {
      return transactions.get(tid);
   }

}
