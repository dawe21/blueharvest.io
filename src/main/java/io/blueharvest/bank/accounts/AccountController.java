package io.blueharvest.bank.accounts;
import io.blueharvest.bank.customers.CustomerService;
import io.blueharvest.bank.transactions.Transaction;
import io.blueharvest.bank.util.Path;
import io.blueharvest.bank.util.ViewUtil;
import io.javalin.Handler;

import java.util.Map;
import java.util.Objects;

import static io.blueharvest.bank.util.RequestUtil.*;

public class AccountController {

    /* ----- Pages ------  */

    public static Handler serveAccountsPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        model.put("accounts", AccountService.instance().findAll());
        ctx.render(Path.Template.ACCOUNT_ALL, model);
    };

    public static Handler serveAccountPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        Account account = AccountService.instance().findById(getParamAccountNumber(ctx));
        model.put("account", account);
        model.put("customer", CustomerService.instance().findById(account.getCustomerId()));
        ctx.render(Path.Template.ACCOUNT_ONE, model);
    };

    public static Handler handleUpdatePost = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        Account account = AccountService.instance().findById(getParamAccountNumber(ctx));
        model.put("account", account);
        model.put("customer", CustomerService.instance().findById(account.getCustomerId()));
        Transaction transaction = AccountService.instance().updateAccountAndCreateTransaction(account.getNumber(), getParamAmount(ctx), account.getCustomerId());
        if(transaction != null){
            model.put("success", true);
            model.put("transaction_id", transaction.transactionId);
        }
        ctx.render(Path.Template.ACCOUNT_ONE, model);
    };

    public static Handler serveCreateAccountPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        ctx.render(Path.Template.CREATE_ACCOUNT, model);
    };

    public static Handler handleCreateAccountPost = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);

        Account createdAccount = AccountService.instance().createAccount(getParamAmount(ctx), getFormParamCustomerId(ctx));
        model.put("success", true);
        model.put("new_account", createdAccount.getNumber());
        ctx.render(Path.Template.CREATE_ACCOUNT, model);
    };

    /* ----- JSON API ------  */

    public static Handler getAllAccounts = ctx -> {
        Iterable<Account> allAccounts = AccountService.instance().findAll();
        ctx.json(allAccounts);
    };

    public static Handler getAccount = ctx -> {
        Account account = AccountService.instance().findById(getParamAccountNumber(ctx));
        ctx.json(account);
    };

    public static Handler createAccount = ctx -> {
        Account account = ctx.bodyAsClass(Account.class);
        Account createdAccount = AccountService.instance().createAccount(account.getAmount(), account.getCustomerId());
        CustomerService.instance().addAccount(createdAccount);
        ctx.json(createdAccount);
    };

    public static Handler deleteAccount = ctx -> {
        Account account = ctx.bodyAsClass(Account.class);
        AccountService.instance().delete(account.getNumber());
        ctx.status(201);
    };

    public static Handler updateAccount = ctx -> {
        String number = Objects.requireNonNull(ctx.pathParam("number"));
        Account account = ctx.bodyAsClass(Account.class);
        AccountService.instance().updateAccountAndCreateTransaction(number, account.getAmount(), account.getCustomerId());
        ctx.status(201);
    };

}
