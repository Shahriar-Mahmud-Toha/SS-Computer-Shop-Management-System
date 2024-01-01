package dev.repository;

import dev.domain.Admin;
import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class AdminRepository {
    private SessionFactory sessionFactory;

    public AdminRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Admin> getAllAdmins() {
        Session session = sessionFactory.getCurrentSession();
        Query<Admin> adminQuery = session.createQuery("FROM Admin",Admin.class);
        System.out.println(adminQuery.getResultList());
        return adminQuery.getResultList();
    }
    public Admin getAdminByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Admin> adminQuery = session.createQuery("FROM Admin where email=:email", Admin.class);
        adminQuery.setParameter("email", email);

        try {
            return adminQuery.getSingleResult();
        } catch (NoResultException e) {
            // Handle the case where there is no result
            return null; // or throw a custom exception if needed
        }
    }

    public void create(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.save(admin);
    }
    public void updateAdmin(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.update(admin);
    }
    public boolean deleteAdminById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Admin admin = session.get(Admin.class, id);
        if (admin != null) {
            session.delete(admin);
            return true;
        }
        return false;
    }
    public boolean deleteAdminByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        var data = getAdminByEmail(email);
        if(data==null){
            return false;
        }
        Admin admin = session.get(Admin.class, data.getId());
        if (admin != null) {
            session.delete(admin);
            return true;
        }
        return false;
    }
}
