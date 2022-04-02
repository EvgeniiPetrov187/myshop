package com.petrov.service;

import com.petrov.Utils;
import com.petrov.controller.dto.ProductDto;
import com.petrov.dao.ProductDao;
import com.petrov.entity.Product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static com.petrov.Utils.mapProductDto;

@Stateless
public class ProductService implements Serializable {

    @EJB
    public ProductDao productDao;

    public List<ProductDto> findAll() {
        return productDao.findAll().stream().map(Utils::mapProduct).collect(Collectors.toList());
    }

    public void saveOrUpdate(ProductDto productDto) {
        Product product = mapProductDto(productDto);
        productDao.saveOrUpdate(product);
    }
}
