package controller;

import bean.LoginDao;
import bean.UserDaoBean;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
    public class Login extends HttpServlet{
    private LoginDao loginDao = new LoginDao();
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");
            Map<String, String> loginHashMap = new HashMap<String,String>();

            if (uname==null||uname.isEmpty()){
                loginHashMap.put("uname","Username Cannot be Empty");
            }
            if (pass==null||pass.isEmpty()){
                loginHashMap.put("pass","Please Enter Password");
            }
            if (loginHashMap.isEmpty()){
                if(loginDao.check(uname, pass)) {

                    request.getSession().setAttribute("username", uname);
                    response.sendRedirect("/JAVAWEB/index.jsp");
                }else {
                    loginHashMap.put("login", "You are not registered. Please Register");

                }
            }
           request.setAttribute("alert",loginHashMap);

            /*if(loginDao.check(uname, pass)) {

                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                response.sendRedirect("/JAVAWEB/index.jsp");
            }else {
                response.sendRedirect("login");

            }*/


        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }

}


