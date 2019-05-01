package io.blueharvest.bank.transactions;

import io.javalin.Handler;

import static io.blueharvest.bank.util.RequestUtil.getParamTransactionId;


public class TransactionController {

   /* --- JSON ---*/

   public static Handler getTransaction = ctx -> {
      Transaction transaction = TransactionService.instance().findById(getParamTransactionId(ctx));
      ctx.json(transaction);
   };

}
