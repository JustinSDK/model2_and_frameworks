package cc.openhome.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {
    // request parameter
    private String username;
    private String password;
    
    // configuration
    private String user;
    private String passwd;
    
    @Override
    public String execute() throws Exception {
        if(username.equals(user) && password.equals(passwd)) {
            ServletActionContext.getRequest().getSession().setAttribute("login", username);
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public void validate() {
        if(username == null || username.trim().length() == 0) {
            addFieldError("username", "username is empty");
        }
        if(password == null || password.trim().length() == 0) {
            addFieldError("password", "username is empty");
        }
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
}
