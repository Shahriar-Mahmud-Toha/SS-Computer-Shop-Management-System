package dev.rest;

import dev.domain.Product;
import dev.service.CategoriesService;
import dev.service.ProductsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:7000")
@RestController
public class ProductsRestController {

    private ProductsService productService;
    private CategoriesService categoriesService;

    public ProductsRestController(ProductsService productService, CategoriesService categoriesService) {
        this.productService = productService;
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) throws SQLException {
        int categoryId = retrieveCategoryId(category);
        System.out.println("i am productRestController. coming category ID is:"+categoryId);
        return productService.getProductsByCategoryId(categoryId);
    }

    private int retrieveCategoryId(String category) {
        // Use categoriesRepository or categoriesService to find the category ID based on the name
        return categoriesService.getCategoryIdByName(category); // Assuming a method like this exists in CategoriesService
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable int productId) {
        System.out.println("get mapping called");
        return productService.getProductById(productId);
    }
}
