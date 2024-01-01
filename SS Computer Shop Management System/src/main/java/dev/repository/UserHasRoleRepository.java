package dev.repository;

import dev.domain.Customer;
import dev.domain.User;
import dev.domain.UserHasRole;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class UserHasRoleRepository {
    private SessionFactory sessionFactory;

    public UserHasRoleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<UserHasRole> getAllUserHasRole() {
        Session session = sessionFactory.getCurrentSession();
        Query<UserHasRole> userHasRoleQuery = session.createQuery("FROM UserHasRole",UserHasRole.class);
        return userHasRoleQuery.getResultList();
    }

    public int getUserRoleIdByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("SELECT role_id FROM UserHasRole WHERE email = :email", Integer.class);
        query.setParameter("email", email);
        int roldId = -1;

        try {
            roldId = query.uniqueResult();
        } catch (NoResultException e) {
            roldId = -1;
            throw new RuntimeException("No Email found for the specified email: " + email, e);
        }

        return roldId;
    }

    public void save(UserHasRole userHasRole) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userHasRole);
    }

}
