package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet",urlPatterns="/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        String username = req.getParameter("username"); //hello?username=kim 이거 보내면 kim저장됨
        System.out.println("username = " + username);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8"); //위 두개는 content type에 들어감
        resp.getWriter().write("hello " + username);
    }
}
