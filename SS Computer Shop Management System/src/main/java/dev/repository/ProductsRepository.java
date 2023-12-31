package dev.repository;

import dev.domain.Categories;
import dev.domain.Product;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository {
    SessionFactory sessionFactory;

    public ProductsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> productQuery = session.createQuery("FROM Product WHERE category.id = :categoryId", Product.class);
        productQuery.setParameter("categoryId", categoryId); // Bind the parameter
        System.out.println("I am productRepository. product query is:" + productQuery.getResultList());

        var products = productQuery.getResultList();
        products.forEach(product -> {
            if (Hibernate.isInitialized(product.getCategory())) {
                Hibernate.initialize(product.getCategory());
            }
        });

        return products;
    }

    public Product findById(int productId) {
        System.out.println("1");
        Session session = sessionFactory.getCurrentSession();
//        Query<Product> productQuery = session.createQuery("FROM Product WHERE id = :productId", Product.class);
//        productQuery.setParameter("id", productId);
//        System.out.println("2");
//
//        Product product = productQuery.getSingleResult(); // Fetch a single product
//        System.out.println("product: "+product);
//
//        // Initialize the category eagerly to avoid lazy loading issues
//        if (product != null && !Hibernate.isInitialized(product.getCategory())) {
//            Hibernate.initialize(product.getCategory());
//        }

        return session.get(Product.class,productId);
    }

}
