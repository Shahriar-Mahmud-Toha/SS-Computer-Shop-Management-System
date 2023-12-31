package dev.repository;

import dev.domain.Categories;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class CategoriesRepository {
    private SessionFactory sessionFactory;

    public CategoriesRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Categories> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query<Categories> categoriesQuery = session.createQuery("FROM Categories",Categories.class);
        System.out.println(categoriesQuery.getResultList());
        return categoriesQuery.getResultList();
    }


//    public int getCategoryIdByName(String categoryName) {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Integer> query = session.createQuery("SELECT id FROM Categories WHERE name = :categoryName", Integer.class);
//        query.setParameter("categoryName", categoryName);
//        Integer categoryId = query.uniqueResult();
//
//        if (categoryId != null) {
//            return categoryId;
//        } else {
//            // Handle the case where the category is not found
//            return -1; // Or throw an exception
//        }
//    }

}
