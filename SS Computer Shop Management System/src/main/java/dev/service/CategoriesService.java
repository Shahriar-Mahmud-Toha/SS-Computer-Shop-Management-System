package dev.service;

import dev.domain.Categories;
import dev.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoriesService {
    private CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Categories> getAllCategories(){
        return categoriesRepository.getAllCategories();
    }

    public int getCategoryIdByName(String category) {
        return categoriesRepository.getCategoryIdByName(category);
    }
}
