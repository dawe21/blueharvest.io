package io.blueharvest.bank.util;

import java.util.HashMap;
import java.util.Map;

import io.javalin.Context;
import io.javalin.ErrorHandler;

import static io.blueharvest.bank.util.RequestUtil.*;

public class ViewUtil {

   public static Map<String, Object> baseModel(Context ctx) {
      Map<String, Object> model = new HashMap<>();
      model.put("msg", new MessageBundle(getSessionLocale(ctx)));
      return model;
   }

   public static ErrorHandler notFound = ctx -> {
      ctx.render(Path.Template.NOT_FOUND, baseModel(ctx));
   };

}