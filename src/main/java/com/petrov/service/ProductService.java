package com.petrov.service;

import com.petrov.Utils;
import com.petrov.controller.dto.ProductDto;
import com.petrov.dao.ProductDao;
import com.petrov.entity.Product;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static com.petrov.Utils.mapProductDto;

@Stateful
public class ProductService implements Serializable {

    @EJB
    private ProductDao productDao;

    public List<ProductDto> findAll() {
        return productDao.findAll().stream().map(Utils::mapProduct).collect(Collectors.toList());
    }

    public void saveOrUpdate(ProductDto productDto) {
        Product product = mapProductDto(productDto);
        productDao.saveOrUpdate(product);
    }
}
