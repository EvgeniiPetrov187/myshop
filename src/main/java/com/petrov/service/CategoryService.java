package com.petrov.service;

import com.petrov.Utils;
import com.petrov.controller.dto.CategoryDto;
import com.petrov.dao.CategoryDao;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.petrov.Utils.mapCategoryDto;

@Stateful
public class CategoryService implements Serializable {

    @EJB
    private CategoryDao categoryDao;

    public List<CategoryDto> findAll() {
        return categoryDao.findAll().stream().map(Utils::mapCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        return mapCategoryDto(categoryDao.findById(id).orElse(null));
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
