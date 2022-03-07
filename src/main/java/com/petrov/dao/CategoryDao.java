package com.petrov.dao;

import com.petrov.entity.Category;

import javax.ejb.Stateful;
import java.util.List;
import java.util.Optional;

@Stateful
public interface CategoryDao {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void saveOrUpdate(Category category);

    void delete(Category category);
}
