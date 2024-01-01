package dev.repository;

import dev.domain.CustomerProfit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerProfitRepository {
    private SessionFactory sessionFactory;

    public CustomerProfitRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(CustomerProfit customerProfit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customerProfit);
    }
}
