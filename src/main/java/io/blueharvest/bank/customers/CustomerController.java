package io.blueharvest.bank.customers;

import io.javalin.Handler;
import static io.blueharvest.bank.util.RequestUtil.getParamCustomerId;

public class CustomerController {

   /* --- JSON ---*/

   public static Handler getAllCustomers = ctx -> {
      Iterable<Customer> allCustomers = CustomerService.instance().findAll();
      ctx.json(allCustomers);
   };

   public static Handler getCustomer = ctx -> {
      Customer customer = CustomerService.instance().findById(getParamCustomerId(ctx));
      try
      {
         ctx.json(customer);
      }
      catch (java.lang.IllegalArgumentException e)
      {

      }
   };

   public static Handler createCustomer = ctx -> {
      Customer customer = ctx.bodyAsClass(Customer.class);
      Customer createdCustomer = CustomerService.instance().createCustomer(customer.getName(),customer.getSureName());
      CustomerService.instance().addCustomer(createdCustomer);
      ctx.json(createdCustomer);
   };

}
