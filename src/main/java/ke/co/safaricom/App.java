package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        // ... Rest of the code remains the same

        // For example, in the post("/animals") route, change the catch block to:
        post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            try {
                Animal animal = new Animal(name);
                animal.save();
                response.redirect("/animals"); // Redirect to the animals list after successful creation
            } catch (IllegalArgumentException exception) {
                response.status(400); // Bad request status code
                model.put("error", "Please enter an animal name.");
                return new ModelAndView(model, layout);
            }
            return null; // Returning null since the redirect is used
        }, new VelocityTemplateEngine());

        // ... Rest of the code remains the same

        // In other routes where there's a successful creation or update, use response.redirect() to redirect to the appropriate page.
    }
}
