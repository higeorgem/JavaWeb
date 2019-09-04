package controller.user;

import bean.UserDaoBean;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class displayAllUser extends HttpServlet {
    UserDaoBean userDaoBean = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ArrayList<User> users = userDaoBean.readAllObjects();
            req.setAttribute("users",users);
            req.getRequestDispatcher("/views/users/list-user.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving users",e);
        }
    }
}
