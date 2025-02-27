package com.articleanalyzer.core.services;

import com.articleanalyzer.core.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleAnalyzer {
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private UserNotifier userNotifier;

    @Autowired
    public ArticleAnalyzer(CategoryService categoryService, UserNotifier userNotifier, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.userNotifier = userNotifier;
        this.categoryRepository = categoryRepository;
    }

    public void analyze() {
        var categories = categoryService.getCategories();
        categoryRepository.saveCategories(categories );
        userNotifier.notifyUsers();
    }
}
