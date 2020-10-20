package by.pvt.home;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.print("<h1>Hello Servlet2</h1>");
        out.println("</html>");
        ServletContext servletCont = getServletContext();
        out.println(servletCont.getInitParameter("contextParam"));
        out.println(getInitParameter("initParam"));

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        if (cart==null){
            cart=new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
        }
        session.setAttribute("cart",cart);
        getServletContext().getRequestDispatcher("/showCart.jsp").forward(req,resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
