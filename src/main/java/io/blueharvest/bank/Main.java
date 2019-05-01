package io.blueharvest.bank;
import io.blueharvest.bank.accounts.AccountController;
import io.blueharvest.bank.customers.CustomerController;
import io.blueharvest.bank.index.IndexController;
import io.blueharvest.bank.transactions.TransactionController;
import io.blueharvest.bank.util.Filters;
import io.blueharvest.bank.util.Path;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

      public static void main(String[] args) {

         Javalin app = Javalin.create()
                 .port(getHerokuAssignedPort())
                 .enableStaticFiles("/public")
                 .enableRouteOverview("/routes")
                 .start()
                 .get("/", ctx -> ctx.result("Welcome to the Bank"));

         app.routes(() -> {

            /* --- Locale --- */
            before(Filters.handleLocaleChange);

            /* --- Web Pages --- */
            get(Path.Web.INDEX, IndexController.serveIndexPage);
            get(Path.Web.ACCOUNTS, AccountController.serveAccountsPage);
            get(Path.Web.ACCOUNT, AccountController.serveAccountPage);
            post(Path.Web.ACCOUNT, AccountController.handleUpdatePost);
            get(Path.Web.CREATE, AccountController.serveCreateAccountPage);
            post(Path.Web.CREATE, AccountController.handleCreateAccountPost);

            /* --- JSON API --- */
            /***
             * Customers
             */
            get(Path.Api.CUSTOMERS, CustomerController.getAllCustomers);

            /***
             * Customer
             */
            get(Path.Api.CUSTOMER_ID, CustomerController.getCustomer);
            post(Path.Api.CUSTOMER, CustomerController.createCustomer);

               /* Requirement: Create Customer
               Can be tested with curl command from commandline:
               curl -X POST -d '{"name":"David","sureName":"welander"}' http://localhost:7000/api/customer
               */

            /* Requirement: Get Customer with Id
               Endpoint: Get to http://localhost:7000/api/customer/:id

               How to test:
               Can be tested with curl command from commandline:
               curl http://localhost:7000/api/customer/0
            */

            /***
             * Transaction
             */
            get(Path.Api.TRANSACTION_ID, TransactionController.getTransaction);

            /***
             * Accounts
             */
            get(Path.Api.ACCOUNTS, AccountController.getAllAccounts);

            /***
             * Account
             */
            path(Path.Api.ACCOUNT, () -> {

               /* Requirement: Create Account
               The API will expose an endpoint which accepts the user information
               (customerID, initialCredit). Once the endpoint is called, a new account
               will be opened connected to the user whose ID is customerID.
               Also, if initialCredit is not 0, a transaction will be sent to the new account.

               Endpoint: Post to http://localhost:7000/bank/api/account

               How to test:
               Can be tested with curl command from commandline
               curl -X POST -d '{"amount":"1000","customerId":"welander"}' http://localhost:7000/api/account
               */
               post(AccountController.createAccount);

               path(Path.Api.ACCOUNT_NUMBER, () -> {
                  get(AccountController.getAccount);
                  patch(AccountController.updateAccount);
                  delete(AccountController.deleteAccount);
               });
            });
         });
      }

      private static int getHerokuAssignedPort() {
         String herokuPort = System.getenv("PORT");
         if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
         }
         return 7000;
      }
}