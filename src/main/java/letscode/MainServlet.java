package letscode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/cool-servlet"})
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
       log("Init work!\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        String params = formatParams(req);
        resp.getWriter().write("i did POST!\nURI: "+uri+"\nParams:\n"+params+"\n");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Servis started \n");
        super.service(req, resp);
        resp.getWriter().write("Servis is it!\n");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        String params = formatParams(req);

        resp.getWriter().write("i did GET!\nURI: "+uri+"\nParams:\n"+params+"\n");
    }

    private String formatParams(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet().
                        stream().
                        map(entry -> {
                            String param = String.join(" and ", entry.getValue());
                            return entry.getKey() + " => " + param;
                        })
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void destroy() {
        log("Destroyed app!!!\n");
    }
}
