package pl.sdacademy.filter;

import pl.sdacademy.dto.CustomerDto;

import javax.naming.event.ObjectChangeListener;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoggedUserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = req.getSession().getAttribute("user");
        if(user == null || !(user instanceof CustomerDto)){
            String url = req.getRequestURL().toString();
            req.getSession().setAttribute("requestedURL", url);
            resp.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
