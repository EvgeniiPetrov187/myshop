package com.petrov.dao;

import com.petrov.entity.Product;

import javax.ejb.Stateful;
import java.util.List;
import java.util.Optional;

@Stateful
public interface ProductDao {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void saveOrUpdate(Product product);

    void delete(Product product);
}
