package Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderHistory")
public class OrderHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mapOrder", OrderStorage.getOrderList());
        getServletContext().getRequestDispatcher("/Shop/orderHistory.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mapOrder", OrderStorage.getOrderList());
        getServletContext().getRequestDispatcher("/Shop/orderHistory.jsp").forward(req,resp);
    }

}