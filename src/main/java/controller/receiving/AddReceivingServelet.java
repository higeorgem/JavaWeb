package controller.receiving;

import bean.ProductDaoBean;
import bean.ReceivingDaoBean;
import model.Product;
import model.Receiving;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "add_receiving")
public class AddReceivingServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String receivalDate = null;
        long batchNo;
        int qty = 0;
        double runningBalance = 0.00;
        double buyingPrice = 0.00;
        double sellingPrice = 0.00;
        int productId = 0;
        boolean validEntry = false;
        Receiving receiving = null;
        Product product = null;
        ProductDaoBean productDaoBean = new ProductDaoBean();
        
               productId = Integer.parseInt(req.getParameter("productId"));

//        RESTRICT USER TO ENTER A RECEIVAL FOR A PRODUCT THAT IS AVAILABLE IN THE DATABASE
        try {
            product = productDaoBean.readOneObject(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (product != null) {
                    qty = Integer.parseInt(req.getParameter("quantity"));

                    buyingPrice = Integer.parseInt(req.getParameter("buyingPrice"));

                    sellingPrice = Integer.parseInt(req.getParameter("sellingPrice"));


//            OUR INITIAL RUNNING BALANCE IS THE QUANTITY THAT WE PROCURE
            runningBalance = qty;

            Receiving receivedBatch = new Receiving(receivalDate, qty, runningBalance, buyingPrice, sellingPrice, productId);
            ReceivingDaoBean receivingDaoBean = new ReceivingDaoBean();
            try {
                if(receivingDaoBean.create(receivedBatch)){
                    resp.sendRedirect("/JAVAWEB/index.jsp");
                }
            } catch (SQLException e) {
                throw new ServletException("Failed to Add a Receiving\n" +e);
            }
            resp.getWriter().write("<html><h4>Successfully Added a Batch</h4></html>");

        } else {
            resp.sendRedirect("add_product");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* try {
            List<Product>products = productDaoBean.readAllObjects();
            req.setAttribute("products", products);
            req.getRequestDispatcher("/views/receiving/add_receiving.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving products", e);
        }*/
        req.getRequestDispatcher("views/receiving/add_receiving.jsp").forward(req,resp);
    }

}

