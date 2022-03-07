package com.petrov.service;

import com.petrov.Utils;
import com.petrov.controller.dto.CategoryDto;;
import com.petrov.dao.CategoryDao;
import com.petrov.dao.CategoryDaoImpl;

import java.util.List;
import java.util.stream.Collectors;

import static com.petrov.Utils.mapCategoryDto;

public class CategoryService {

    private static final CategoryService categoryService = new CategoryService();

    public static CategoryDao categoryDao = CategoryDaoImpl.getDao();

    public List<CategoryDto> findAll() {
        return categoryDao.findAll().stream().map(Utils::mapCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        return mapCategoryDto(categoryDao.findById(id).get());
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }
}
