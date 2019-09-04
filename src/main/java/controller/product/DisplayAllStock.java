package controller.product;

import bean.ProductDaoBean;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/displayS")
public class DisplayAllStock extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDaoBean productDaoBean = new ProductDaoBean();
            List<Product> products = productDaoBean.readAllObjects();

        System.out.println(Arrays.toString(products.toArray()));
        req.setAttribute("products",products);


        req.getRequestDispatcher("/views/product/display_all_stock.jsp").forward(req,resp);
    }
}
