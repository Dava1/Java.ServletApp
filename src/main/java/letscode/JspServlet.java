package letscode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/temp-jsp")
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           ArrayList<User> users =new ArrayList<User>() {{
            add(new User("Egor","Russian",24));
            add(new User("Igor","Nezalezna",55));
            add(new User("Nikita","Bali",109));
            add(new User("Uliana","America",23));
           }};
           req.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/first-jsp.jsp").forward(req,resp);
    }

}
