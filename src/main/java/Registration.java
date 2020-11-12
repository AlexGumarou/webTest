import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            getServletContext().getRequestDispatcher("/RegistrationPage.jsp").forward(request,response);
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String regExpLogin = "[a-zA-Z0-9]+";
        String regExpPass = "([a-zA-Z0-9]*[A-Z]+[0-9]+[a-zA-Z0-9]*||[a-zA-Z0-9]*[0-9]+[A-Z]+[a-zA-Z0-9]*)";
        try {
            if (!ListOfThePersons.map.containsKey(request.getParameter("login")) &&
                    request.getParameter("login").matches(regExpLogin) &&
                    request.getParameter("pass").matches(regExpPass)) {
                ListOfThePersons.addUsers(request.getParameter("login"), request.getParameter("pass"),
                        request.getParameter("name"), request.getParameter("surname"),
                        LocalDate.now().getDayOfYear());
                response.sendRedirect("/");
            } else response.sendRedirect("/registrationIncorrect");
        } finally {
            writer.close();
        }
    }

}
