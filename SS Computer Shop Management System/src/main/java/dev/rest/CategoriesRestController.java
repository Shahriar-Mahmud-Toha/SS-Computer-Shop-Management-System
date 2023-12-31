package dev.rest;

import dev.domain.Categories;
import dev.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:7000")
@RestController
public class CategoriesRestController {
    private CategoriesService categoriesService;

    public CategoriesRestController(CategoriesService categoriesService)  {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public List<Categories> getAllCategories() throws SQLException {
        return categoriesService.getAllCategories();
    }

}
