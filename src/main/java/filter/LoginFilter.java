package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter()
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        String loginURI = "/login";

        boolean isLoggedIn = session !=null && session.getAttribute("username") !=null;
        boolean loginRequest = request1.getRequestURI().equals(loginURI);

if (isLoggedIn || loginRequest){
    chain.doFilter(request1,response1);
        }else {
    response1.sendRedirect(loginURI);
        }
    }

}
