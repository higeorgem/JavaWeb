package controller.sale;

import bean.SaleDaoBean;
import model.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(urlPatterns = "displaySales")
public class DisplayAllSale extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SaleDaoBean saleDaoBean = new SaleDaoBean();
        ArrayList<Sale> sales = saleDaoBean.readAllObjects();

        System.out.println(Arrays.toString(sales.toArray()));
        req.setAttribute("sales",sales);

        req.getRequestDispatcher("/views/sale/view_all_sales.jsp").forward(req,resp);
    }
}
