package next.controller;

import core.db.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    private static final long serialVersionUID = 1L;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (!UserSessionUtils.isLogined(req.getSession())) {
            return "/users/loginForm";
        }
        req.setAttribute("users", DataBase.findAll());

        return "/user/list.jsp";
    }
}
