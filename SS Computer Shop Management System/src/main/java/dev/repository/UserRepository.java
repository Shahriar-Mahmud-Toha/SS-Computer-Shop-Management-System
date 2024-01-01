package dev.repository;

import dev.domain.Customer;
import dev.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User findByEmail(String email) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();

    }
}
