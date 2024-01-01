package dev.repository;

import dev.domain.Customer;
import dev.domain.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User",User.class);
        return userQuery.getResultList();
    }

    public String getUserPasswordByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<String> query = session.createQuery("SELECT password FROM Users WHERE email = :email", String.class);
        query.setParameter("email", email);
        String password;

        try {
            password = query.uniqueResult();
        } catch (NoResultException e) {
            // Handle the case where no result is found
            throw new RuntimeException("No password found for the specified email: " + email, e);
        }

        return password;
    }



    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User findByEmail(String email) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }

}
