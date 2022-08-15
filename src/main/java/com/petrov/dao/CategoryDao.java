package com.petrov.dao;

import com.petrov.entity.Category;

import javax.ejb.Local;
import javax.ejb.Stateful;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Local
public interface CategoryDao {

    Collection<Category> findAll();

    Optional<Category> findById(Long id);

    void saveOrUpdate(Category category);

    void delete(Category category);
}
