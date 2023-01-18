package sn.groupeisi;

import sn.dao.RoleImpl;
import sn.entities.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (value = "/roles", name = "roles")
public class roleServlet extends HttpServlet {
    private static String VIEW_PATH = "/WEB-INF/views/roles/";
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if(email == null){ // si l'utilisateur n'est pas authentifié
            response.sendRedirect("/logout");
        }else{
            String param = request.getParameter("param");
            if(param != null){
                if(param.equals("add")){
                    this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
                }
            }else{
                RoleImpl roleDAO = new RoleImpl ();
                Role r = new Role ();
                List<Role> listRole = roleDAO.getAll ();
                request.setAttribute("listRole", listRole);
                request.setAttribute("email", email);
                this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name.equals("")){
            request.setAttribute("error", "Veuillez renseigner le role");
            this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
        }else{
            RoleImpl roleDAO = new RoleImpl ();
            Role r = new Role ();
            r.setName(name);
            int result = roleDAO.save (r);
            if(result == 1){
                request.setAttribute("success", "Crée avec succès");
            }else{
                request.setAttribute("error", "Une erreur s'est produite");
            }

            response.sendRedirect("roles");
        }
    }

}
