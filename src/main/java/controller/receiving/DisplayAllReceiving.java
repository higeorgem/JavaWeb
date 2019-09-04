package controller.receiving;

import bean.ReceivingDaoBean;
import model.Receiving;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "displayR")
public class DisplayAllReceiving extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReceivingDaoBean receivingDaoBean = new ReceivingDaoBean();
        ArrayList<Receiving> receivings = receivingDaoBean.readAllObjects();

        System.out.println(Arrays.toString(receivings.toArray()));
        req.setAttribute("receivings",receivings);


        req.getRequestDispatcher("/views/receiving/display_all_receiving.jsp").forward(req,resp);
    }

}
