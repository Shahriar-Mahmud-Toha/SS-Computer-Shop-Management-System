//package dev.repository;
//
//import dev.domain.Categories;
//import dev.domain.Product;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ProductsRepository {
//    SessionFactory sessionFactory;
//
//    public ProductsRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public List<Product> getProductsByCategoryId(int categoryId) {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Product> productQuery = session.createQuery("FROM Product WHERE category.id = :categoryId", Product.class);
//        productQuery.setParameter("categoryId", categoryId); // Bind the parameter
//        System.out.println("I am productRepository. product query is:" + productQuery.getResultList());
//        return productQuery.getResultList();
//    }
//
//}
