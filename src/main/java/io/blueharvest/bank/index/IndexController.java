package io.blueharvest.bank.index;
import io.blueharvest.bank.util.Path;
import io.blueharvest.bank.util.ViewUtil;
import io.javalin.Handler;

import java.util.Map;

public class IndexController {
    public static Handler serveIndexPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        ctx.render(Path.Template.INDEX, model);
    };
}
