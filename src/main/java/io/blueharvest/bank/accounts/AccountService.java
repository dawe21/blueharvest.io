package io.blueharvest.bank.accounts;

import io.blueharvest.bank.transactions.Transaction;
import io.blueharvest.bank.transactions.TransactionService;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AccountService {

    /**
     * AccountService is a Singelton
     * We only want one instance of the AccountService.
     */
    private AccountService () {}
    private static AccountService accountService = null;
    private static final String BANK_ACCOUNT_PREFIX_NUMBER = "1234";

    public static Map<String, Account> accounts = new HashMap<>();
    private static final AtomicInteger accountCount = new AtomicInteger();
    private static final Logger LOGGER = Logger.getLogger( AccountService .class.getName());

    /**
     * AccountService
     * @return AccountService
     */
    public static AccountService instance() {
        if (accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }

    public Account findById(String id) {
        return accounts.get(id);
    }

    public Account createAccount(double amount, String customerId) {
        Account account = new Account(nextAccountNumber(),0,customerId);
        addAccount(account);
        updateAccountAndCreateTransaction(account.getNumber(),amount,account.getCustomerId());
        return account;
    }

    public void addAccount(Account account) {
        accounts.put(account.getNumber(), account);
        // Sort the accounts
        accounts = accounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public String nextAccountNumber() {
        String accountNumberEnd = Integer.toString(accountCount.getAndIncrement());
        while(accountNumberEnd.length()<9){
            accountNumberEnd = "0" + accountNumberEnd;
        }
        return BANK_ACCOUNT_PREFIX_NUMBER + accountNumberEnd;
    }

    public Transaction updateAccountAndCreateTransaction(String number, double amount, String customerId) {
        Transaction transaction = null;
        Account account = accounts.get(number);
        if(amount<account.getAmount() || amount>account.getAmount()) {
            transaction = TransactionService.instance().createTransaction(amount, account);
        }
        if (customerId != null) {
            account.setCustomerId(customerId);
        }
        return transaction;
    }

    public void delete(String number) {
        accounts.remove(number);
    }

    public Iterable<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }
 }