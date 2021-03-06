package login;

import db.ConnectionDB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationIncorrect")
public class RegistrationIncorrect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            getServletContext().getRequestDispatcher("/User/registrationPageIncorrect.jsp").forward(request,response);
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        if (ConnectionDB.getInstance().isUser(login, pass)){
            response.sendRedirect("/registrationIncorrect");
        } else {
            ConnectionDB.getInstance().addUser(login, pass, name, surname);
            response.sendRedirect("/");
        }
    }
}
