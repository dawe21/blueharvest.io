package io.blueharvest.bank.transactions;

public class Transaction {
   public String accountNumber;
   public double transactionAmount;
   public String transactionId;
   private final long creationTimeMillis;

   public String getAccountNumber() {
      return accountNumber;
   }

   public double getTransactionAmount() {
      return transactionAmount;
   }

   public String getTransactionId() {
      return transactionId;
   }

   public long getCreationTimeMillis() {
      return creationTimeMillis;
   }

   public Transaction(String transactionId, String accountNumber, double transactionAmount) {
      this.creationTimeMillis = System.currentTimeMillis();
      this.accountNumber=accountNumber;
      this.transactionAmount = transactionAmount;
      this.transactionId = transactionId;
   }

   @Override
   public String toString() {
      return "Transaction{" +
              "accountNumber='" + accountNumber + '\'' +
              ", transactionAmount='" + transactionAmount + '\'' +
              ", transactionId='" + transactionId + '\'' +
              ", creationTimeMillis=" + creationTimeMillis +
              '}';
   }
}
