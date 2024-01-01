package dev.repository;

import dev.domain.Role;

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
public class RoleRepository {
    private SessionFactory sessionFactory;

    public RoleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public int getRoleIdByName(String name){
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("SELECT id FROM Role WHERE name = :name", Integer.class);
        query.setParameter("name", name);
        int role_id = -1;

        try {
            role_id = query.uniqueResult();
        } catch (NoResultException e) {
            role_id = -1;
            throw new RuntimeException("No Role found for the specified Name: " + name, e);
        }

        return role_id;
    }
}
