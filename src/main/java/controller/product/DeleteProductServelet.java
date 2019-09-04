package controller.product;

import bean.ProductDaoBean;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "", urlPatterns = "/deleteP")
public class DeleteProductServelet extends HttpServlet {

    public DeleteProductServelet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productId = Integer.parseInt(req.getParameter("productId"));
        ProductDaoBean  productDaoBean =  new ProductDaoBean();

        try {
            productDaoBean.deleteWithID(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("./displayS").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
}
}
