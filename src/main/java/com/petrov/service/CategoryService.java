package com.petrov.service;

import com.petrov.Utils;
import com.petrov.controller.dto.CategoryDto;
import com.petrov.dao.CategoryDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.petrov.Utils.mapCategoryDto;

@Stateless
public class CategoryService implements Serializable {

    @EJB
    public CategoryDao categoryDao;

    public List<CategoryDto> findAll() {
        return categoryDao.findAll().stream().map(Utils::mapCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        return mapCategoryDto(categoryDao.findById(id).get());
    }

    public CategoryDto findByTitle(String title) {
        List<CategoryDto> categoryDtoList = categoryDao.findAll().stream().map(Utils::mapCategoryDto)
                .filter(Objects::nonNull).collect(Collectors.toList());
        for (CategoryDto categoryDto : categoryDtoList) {
            if (title.equals(categoryDto.getTitle())) {
                return categoryDto;
            }
        }
        return null;
    }
}
