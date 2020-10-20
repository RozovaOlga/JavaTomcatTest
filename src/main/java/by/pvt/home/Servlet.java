package by.pvt.home;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.print("<h1>Hello Servlet</h1>");
        out.println("</html>");
        Enumeration<String> params = request.getHeaderNames();
        String info = request.getHeader("User-Agent");
        out.println(info);
        String infoLang = request.getHeader("Accept-Language");
        out.println(infoLang);
        response.setContentType("text/html");
        setTestCookie(request, response);
        getTestCookie(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void getTestCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        for (Cookie cookie : cookies) {
            out.println("<h3>" + cookie.getName() + ":" + cookie.getValue() + "</h3>");
            out.println("</html>");
        }
    }

    private void setTestCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie1 = new Cookie("some_ID", "123");
        Cookie cookie2 = new Cookie("Name", "Tom");
        cookie1.setMaxAge(10);
        cookie2.setMaxAge(10);
        response.addCookie(cookie1);
        response.addCookie(cookie2);

    }
}