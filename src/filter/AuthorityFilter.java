package filter;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by GeorgeYang on 2017/12/26.
 */
@WebFilter(filterName = "AuthorityFilter", urlPatterns = {"/*"})
@MultipartConfig
public class AuthorityFilter implements Filter {
    private FilterConfig filterConfig;

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charSet=UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpSession session = httpRequest.getSession();
        String requestPath = httpRequest.getServletPath();
        System.out.println(requestPath);
        System.out.println(session.getAttribute("state"));

        if (session.getAttribute("state") == null
                && !requestPath.contains("login")
                && !requestPath.contains("css")
                && !requestPath.contains("font")
                && !requestPath.endsWith("js")
                ){
            req.setAttribute("warning", "请先登陆");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
