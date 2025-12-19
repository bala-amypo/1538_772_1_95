package com.example.budget.service;

import com.example.budget.model.Category;
import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
}
