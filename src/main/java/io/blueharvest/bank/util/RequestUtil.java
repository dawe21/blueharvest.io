package io.blueharvest.bank.util;
import io.javalin.Context;

public class RequestUtil {

   public static String getQueryLocale(Context ctx) {
      return ctx.queryParam("locale");
   }

   public static String getSessionLocale(Context ctx) {
      return (String) ctx.sessionAttribute("locale");
   }

   public static String getParamAccountNumber(Context ctx) {
      return ctx.pathParam("number");
   }

   public static String getParamCustomerId(Context ctx) {
      return ctx.pathParam("cid");
   }

   public static String getParamTransactionId(Context ctx) {
      return ctx.pathParam("tid");
   }

   public static double getParamAmount(Context ctx) {
      return Double.parseDouble(ctx.formParam("amount"));
   }
   public static String getFormParamCustomerId(Context ctx) {
      return ctx.formParam("cid");
   }

}
