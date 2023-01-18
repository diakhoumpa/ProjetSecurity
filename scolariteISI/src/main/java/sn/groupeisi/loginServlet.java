package sn.groupeisi;

import sn.dao.IUser;
import sn.dao.UserImpl;
import sn.entities.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet ("/login")

public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUser UDAO;
    private UserImpl udaoValide;
    @Override
    public void init(ServletConfig config) throws ServletException {
        UDAO = new UserImpl();
        udaoValide = new UserImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            e.printStackTrace(); }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (udaoValide.validate(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("/users");
        } else {
            request.setAttribute("error", "Username ou Password  incorrect !!!");
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
