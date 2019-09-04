package controller.product;

import bean.CoreLogic;
import bean.ProductDaoBean;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/edit_product")
public class EditProductServelet extends HttpServlet {

    private String productName;
    private String productDescription;
    boolean valid = false;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        try {
           Product product = new ProductDaoBean().readOneObject(productId);
            req.setAttribute("product",product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            req.getRequestDispatcher("views/product/edit_product.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = null;
        String productName =  req.getParameter("productName");
        String productDescription = req.getParameter("productDescription");
        ProductDaoBean  productDaoBean =  new ProductDaoBean();
        Integer productId = Integer.parseInt(req.getParameter("productId"));

        try {
            product = productDaoBean.readOneObject(productId);
            if (product !=null) {
                product.setProductName(productName);
                product.setProductDescription(productDescription);
                productDaoBean.update(product);
                resp.sendRedirect("displayS");
            }else {
                resp.sendRedirect("add_product");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
