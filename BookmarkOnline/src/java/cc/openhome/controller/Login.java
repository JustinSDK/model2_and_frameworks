package cc.openhome.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    private String username;
    private String password;
    private String SUCCESS_VIEW = "success.view";
    private String ERROR_VIEW = "error.view";

    @Override
    public void init() throws ServletException {
        super.init();
        this.username = this.getInitParameter("username");
        this.password = this.getInitParameter("password");
        if(this.getInitParameter("SUCCESS") != null) {
            SUCCESS_VIEW = this.getInitParameter("SUCCESS");
        }
        if(this.getInitParameter("ERROR") != null) {
            ERROR_VIEW = this.getInitParameter("ERROR");
        }
    }

    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                            throws ServletException, IOException {
        if(username.equals(request.getParameter("username")) &&
           password.equals(request.getParameter("password"))) {
            request.getSession().setAttribute("login", username);
            response.sendRedirect(SUCCESS_VIEW);
        }
        else {
            response.sendRedirect(ERROR_VIEW);
        }
    } 
}
