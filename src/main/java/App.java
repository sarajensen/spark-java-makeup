import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("makeups", request.session().attribute("makeups"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/makeups", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    ArrayList<Makeup> makeups = request.session().attribute("makeups");
      if (makeups == null) {
        makeups = new ArrayList<Makeup>();
        request.session().attribute("makeups", makeups);
      }
      String brand = request.queryParams("brand");
      String itemName = request.queryParams("itemName");
      Integer price = Integer.parseInt(request.queryParams("price"));


     Makeup newMakeup = new Makeup(brand, itemName, price);
     makeups.add(newMakeup);

      model.put("template", "templates/makeup-entry.vtl");
      return new ModelAndView(model, layout);
    },  new VelocityTemplateEngine());
  }
}
