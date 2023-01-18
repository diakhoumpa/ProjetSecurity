package sn.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.config.HibernateUtil;
import sn.entities.Role;

import java.util.List;

public class RoleImpl implements IRole {
    //OUVERTURE SESSION
    private Session session;
    private Transaction transaction;

    public RoleImpl () {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public int save(Role role) {
        //gestion execption
        try {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Role role) {
        return 0;
    }

    @Override
    public int remove(int id) {
        //gestion execption
        try {
            transaction = session.beginTransaction();
            session.delete(get(id));
            transaction.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Role get(int id) {
        return session.get(Role.class,id);
    }

    @Override
    public List<Role> getAll() {
        List listOfRole = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfRole = session.createQuery("from Role").list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfRole;

    }
}
