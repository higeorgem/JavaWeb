package controller.sale;

import bean.CustomerDaoBean;
import bean.ProductDaoBean;
import bean.ReceivingDaoBean;
import bean.SaleDaoBean;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/make_sale")
public class makeSaleServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int productId;
        int qty;
        String saleDate = null;
        String customerName;
        Receiving receiving = null;
        Product product = null;
        User user = new User();

        //user = (User) req.getAttribute("username");

        productId = Integer.parseInt(req.getParameter("productId"));

        try {
//            we check if a product with the inputed id exist in the receiving table
            receiving = new ReceivingDaoBean().readOneObject(productId);
            product = new ProductDaoBean().readOneObject(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (receiving != null) {
            qty = Integer.parseInt(req.getParameter("quantity"));
            customerName = req.getParameter("customerName");
            String userName = (String) req.getSession().getAttribute("username");
           user.setUserName(userName);
            Sale sale = new Sale(saleDate, qty, productId, product.getProductName(), receiving.getSellingPrice(), customerName, user.getUserName(), receiving.getProductId());
            SaleDaoBean saleDaoBean = new SaleDaoBean();
            Customer customer = new Customer(customerName);
            CustomerDaoBean customerDaoBean = new  CustomerDaoBean();
            try {
                if (saleDaoBean.create(sale)) {
                    customerDaoBean.create(customer);
                    resp.sendRedirect("displaySales");
                }
            } catch (SQLException e) {
                throw new ServletException("Error trying to Sell", e);

            }

        } else {
            resp.sendRedirect("add_receiving");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/sale/make_sale.jsp").forward(req,resp);
    }
}
