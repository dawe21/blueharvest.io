package io.blueharvest.bank.util;

public class Path {

   public static class Api {
      public static final String CUSTOMER = "api/customer";
      public static final String CUSTOMERS = "api/customers";
      public static final String CUSTOMER_ID = "api/customer/:cid";
      public static final String TRANSACTION_ID = "api/transaction/:tid";
      public static final String ACCOUNTS = "api/accounts";
      public static final String ACCOUNT = "api/account";
      public static final String ACCOUNT_NUMBER = ":number";
   }

   public static class Web {
      public static final String INDEX = "/index";
      public static final String ACCOUNTS = "/accounts";
      public static final String ACCOUNT = "/account/:number";
      public static final String CREATE = "/create_account";
   }


   public static class Template {
      public static final String INDEX = "/velocity/index/index.vm";
      public static final String ACCOUNT_ALL = "/velocity/account/all.vm";
      public static final String ACCOUNT_ONE = "/velocity/account/one.vm";
      public static final String CREATE_ACCOUNT = "/velocity/account/create.vm";
      public static final String NOT_FOUND = "/velocity/notFound.vm";
   }

}
