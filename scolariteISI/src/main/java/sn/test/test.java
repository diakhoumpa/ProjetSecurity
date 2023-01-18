package sn.test;

import sn.dao.IUser;
import sn.dao.RoleImpl;
import sn.dao.UserImpl;
import sn.entities.Role;
import sn.entities.User;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String args[]) {






       // UserImpl userDao = new UserImpl();
       // User user = new User();
       // user.setFirsName("Diams");
      //  user.setLastName("sow");

      //  List<Role> roles = new ArrayList<Role>();

        RoleImpl roleDao = new RoleImpl();
        Role role = new Role();

        IUser userDao = new UserImpl();
        User user = new User();
        user.setFirsName("Marieme");
        user.setLastName("Fall");
        user.setEmail("diakhoumpa@isi.com");
        user.setPassword("passer");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleDao.get(1));
        user.setRoles(roles);
        int resultat = userDao.save(user);
        System.out.println(resultat);


    }
}
