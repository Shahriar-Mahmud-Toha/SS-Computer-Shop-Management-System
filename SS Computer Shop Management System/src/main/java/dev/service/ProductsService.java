//package dev.service;
//
//import dev.domain.Product;
//import dev.repository.ProductsRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class ProductsService {
//
//    private ProductsRepository productsRepository;
//
//    public ProductsService(ProductsRepository productsRepository) {
//        this.productsRepository = productsRepository;
//    }
//
//    public List<Product> getProductsByCategoryId(int categoryId) {
//        return productsRepository.getProductsByCategoryId(categoryId);
//    }
//
//}
