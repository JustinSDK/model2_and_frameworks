package cc.openhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UserController extends SimpleFormController {
    private String username;
    private String password;    
    
    public UserController() {
        setCommandClass(UserForm.class);
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        UserForm userForm = (UserForm) command;
        if(username.equals(userForm.getUsername()) &&
           password.equals(userForm.getPassword())) {
            request.getSession().setAttribute("login", username);
            return new ModelAndView(getSuccessView());            
        }
        return new ModelAndView(getFormView());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
