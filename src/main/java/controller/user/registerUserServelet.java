package controller.user;

import bean.UserDaoBean;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register_user")
public class registerUserServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
            String userPassword = req.getParameter("userPassword");
            try {
                User user = new User(userName, userPassword);
                UserDaoBean userDaoBean = new UserDaoBean();
                if(userDaoBean.create(user)){
                    resp.sendRedirect("/JAVAWEB/index.jsp");
                }else{
                    resp.sendRedirect("login");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

