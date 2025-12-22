package com.example.demo.service;

import com.example.demo.model.Category;
import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category getById(Long id);
    List<Category> getAll();
    void delete(Long id);
}
