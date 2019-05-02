package io.blueharvest.bank.customers;

import io.blueharvest.bank.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CustomerService {

   /**
    * CustomerService is a Singelton
    * We only want one instance of the CustomerService.
    */
   private CustomerService() {
   }

   private static CustomerService customerService = null;

   private static Map<String, Customer> customers = new HashMap<>();
   private static final AtomicInteger customerCount = new AtomicInteger(0);

   /**
    * CustomerService
    * @return CustomerService
    */
   public static CustomerService instance() {
      if (customerService == null) {
         customerService = new CustomerService();
      }
      return customerService;
   }

   public Customer findById(String cid) {
      return customers.get(cid);
   }

   public Customer createCustomer(String name, String surname) {
      Customer customer = new Customer();
      customer.setCustomerId(nextCustomerNumber());
      customer.setName(name);
      customer.setSurname(surname);
      return customer;
   }

   public void addCustomer(Customer customer) {
      customers.put(customer.getCustomerId(), customer);

      // Sort the customers
      customers = customers.entrySet().stream()
              .sorted(Map.Entry.comparingByKey())
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                      (oldValue, newValue) -> oldValue, LinkedHashMap::new));
   }

   public String nextCustomerNumber() {
      return Integer.toString(customerCount.getAndIncrement());
   }

   public void addAccount(Account account) {
      Customer customer = findById(account.getCustomerId());
      customer.addAccount(account);
   }

   public Iterable<Customer> findAll() {
      return new ArrayList<>(customers.values());
   }
}