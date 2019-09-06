package controller;

import bean.LoginDao;
import bean.UserDaoBean;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
    public class Login extends HttpServlet{
    private LoginDao loginDao = new LoginDao();
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter printWriter = response.getWriter();
            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");

            if(loginDao.check(uname, pass) && (uname !=null) && (pass !=null )) {

                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                User user = new User();
                String currentUser = (String) session.getAttribute("username");
                user.setUserName(currentUser);
                printWriter.write("<script>alert('Welcome!!!')</script>");
                printWriter.write("<script>window.open('index.jsp','_self')</script>");
                //response.sendRedirect("/JAVAWEB/index.jsp");
            }else {
                response.sendRedirect("login");

            }


        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }

}


