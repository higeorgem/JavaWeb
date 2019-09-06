package controller.product;

import bean.ProductDaoBean;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet (urlPatterns = "/add_product")
public class AddProductServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        /*PrintWriter pr = resp.getWriter();
        pr.write("We are here");
        pr.close();*/
        req.getRequestDispatcher("/views/product/add_product.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

            String productName = req.getParameter("productName");
            productName = productName.toUpperCase();
            if (!productName.toUpperCase().matches("[A-Z][A-Z]*[A-Z]?$")){
                resp.sendRedirect("add_product");
            }else{
                String productDescription = req.getParameter("productDescription");


                Product product = new Product(productName, productDescription);
                ProductDaoBean productDaoBean = new ProductDaoBean();
                try {
                    if(productDaoBean.create(product)){
                        resp.sendRedirect("displayS");
                    }else {
                        resp.sendRedirect("add_product");
                    }
                } catch (SQLException e) {
                    throw new ServletException("<script>alert('Error connecting!')</script>"+e);
                }
            }
    }
    }
