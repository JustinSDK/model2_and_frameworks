package cc.openhome.web;

import cc.openhome.controller.BookmarkController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private String loginPage;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().equals(BookmarkController.class)) {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
                response.sendRedirect(loginPage);
                return false;
            }
        }
        return true;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
