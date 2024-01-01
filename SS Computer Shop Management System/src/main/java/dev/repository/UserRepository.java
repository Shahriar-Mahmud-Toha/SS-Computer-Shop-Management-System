package dev.repository;

import dev.domain.Categories;
import dev.domain.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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
        System.out.println(userQuery.getResultList());
        return userQuery.getResultList();
    }

    public String getUserPasswordByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<String> query = session.createQuery("SELECT password FROM Users WHERE email = :email", String.class);
        query.setParameter("email", email);
        String password = query.uniqueResult();

        if (password != null) {
            return password;
        } else {
            return null; // Or throw an exception
        }
    }

}
