package dev.repository;

import dev.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    private SessionFactory sessionFactory;

    public CustomerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);

    }

    public Customer findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Customer WHERE email = :email", Customer.class)
                .setParameter("email", email)
                .uniqueResult();
    }

}
