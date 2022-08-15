package com.petrov.dao;

import com.petrov.entity.Product;

import javax.ejb.Local;
import javax.ejb.Stateful;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductDao {

    Collection<Product> findAll();

    Optional<Product> findById(Long id);

    void saveOrUpdate(Product product);

    void delete(Product product);
}
