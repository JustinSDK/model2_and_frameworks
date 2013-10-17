package cc.openhome.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport implements ModelDriven {
    private UserForm userForm = new UserForm();
    
    // configuration
    private String user;
    private String passwd;
    
    @Override
    public String execute() throws Exception {
        if(userForm.getUsername().equals(user) && userForm.getPassword().equals(passwd)) {
            ServletActionContext.getRequest().getSession().setAttribute("login", userForm.getUsername());
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public void validate() {
        if(userForm.getUsername() == null || userForm.getUsername().trim().length() == 0) {
            addFieldError("username", "username is empty");
        }
        if(userForm.getPassword() == null || userForm.getPassword().trim().length() == 0) {
            addFieldError("password", "username is empty");
        }
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
    
    

    public Object getModel() {
        return userForm;
    }
    
}
