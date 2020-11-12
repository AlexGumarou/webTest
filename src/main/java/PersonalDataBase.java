import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data")
public class PersonalDataBase extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            for (int i = 0; i < ListOfThePersons.list.size(); i++) {
                writer.println(ListOfThePersons.list.get(i).getLogin() + " " +
                        ListOfThePersons.list.get(i).getPass() + " " +
                        ListOfThePersons.list.get(i).getName() + " " +
                        ListOfThePersons.list.get(i).getSurname() + "<br>");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
