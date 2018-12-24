package next.servlet;

import next.controller.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private Map<String, Controller> mappings = new HashMap<>();

    public RequestMapping() {
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/loginForm", new ForwardController("/user/login.jsp"));
        mappings.put("/users/updateForm", new UpdateUserFormController());
        mappings.put("/users/update", new UpdateUserController());
        mappings.put("/users/create", new CreateUserController());
        mappings.put("", new HomeController());
        mappings.put("/users", new ListUserController());
        mappings.put("/users/login", new LoginController());
        mappings.put("/users/profile", new ProfileController());
        mappings.put("/users/logout", new LogoutController());
    }

    public Controller findController(String requestUrl) {
        return this.mappings.get(requestUrl);
    }
}
