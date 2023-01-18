package sn.groupeisi;

import sn.dao.RoleImpl;
import sn.dao.UserImpl;
import sn.entities.Role;
import sn.entities.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (value = "/users", name = "users")
public class userservlet extends HttpServlet {
    private static String VIEW_PATH = "/WEB-INF/views/users/";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname  = request.getParameter("lastname");
        String email  = request.getParameter("email");
        String password  = request.getParameter("password");
        // int  idrole = Integer.parseInt(request. getParameter("role"));
        if(firstname.equals("") && password.equals("") && lastname.equals("") && email.equals("")){
            request.setAttribute("error", "Veuillez renseigner tous les champs");
            this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
        }else{
            UserImpl userDAO = new UserImpl ();
            User u = new User ();
            u.setFirsName (firstname);
            u.setLastName (lastname);
            u.setEmail (email);
            u.setPassword(password);
            List<Role> listRole = new ArrayList<> ();
            RoleImpl rdto =new RoleImpl ();
            Role r = new Role ();
            List<Role> roles = rdto.getAll ();
            String resultat =request.getParameter ("role");
            for (Role choise_role:roles){
                if (choise_role.getName () == resultat){
                    listRole.add (choise_role);
                    break;
                }
            }
            // Droit droit = new Droit ();
            //droit.setId (idrole);
            u.setRoles (listRole);
            int result = userDAO.save (u);
            if(result == 1){
                request.setAttribute("success", "Crée avec succès");
            }else{
                request.setAttribute("error", "Une erreur s'est produite");
            }

            response.sendRedirect("users");
        }
    }

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
                    RoleImpl roleDAO = new RoleImpl ();
                    Role r = new Role ();
                    List<Role> listRole = roleDAO.getAll ();
                    request.setAttribute("listRole", listRole);
                    this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
                }
            }
            else{
                UserImpl userDAO = new UserImpl ();
                RoleImpl roleDAO = new RoleImpl ();
                User u = new User ();
                List<User> listUser = userDAO.getAll ();
                request.setAttribute("listUser", listUser);
                request.setAttribute("email", email);
                this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
            }


        }
    }
}
