package cc.openhome.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecurityFilter implements Filter {
    private String  LOGIN_PAGE = "login.html";
    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("LOGIN_PAGE") != null) {
            LOGIN_PAGE = filterConfig.getInitParameter("LOGIN_PAGE");
        }
    }

    public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
                         throws IOException, ServletException {
        HttpSession session =
                ((HttpServletRequest) request).getSession();
        if(session.getAttribute("login") == null) {
            ((HttpServletResponse) response).sendRedirect(LOGIN_PAGE);
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
