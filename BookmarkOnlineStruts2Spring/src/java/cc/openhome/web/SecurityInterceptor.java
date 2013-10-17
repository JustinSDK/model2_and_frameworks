package cc.openhome.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class SecurityInterceptor extends AbstractInterceptor { 
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
         HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("login") == null) {
            return Action.LOGIN;
        }
        return ai.invoke();
    }
}
