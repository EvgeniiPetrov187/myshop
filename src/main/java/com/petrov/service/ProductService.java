package com.petrov.service;

import com.petrov.Utils;
import com.petrov.controller.dto.ProductDto;
import com.petrov.dao.ProductDao;
import com.petrov.dao.ProductDaoImpl;
import com.petrov.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

import static com.petrov.Utils.mapProductDto;

public class ProductService {

    private static final ProductService productService = new ProductService();

    public ProductDao productDao = ProductDaoImpl.getProductDao();

    public List<ProductDto> findAll() {
        return productDao.findAll().stream().map(Utils::mapProduct).collect(Collectors.toList());
    }

    public void saveOrUpdate(ProductDto productDto) {
        Product product = mapProductDto(productDto);
        productDao.saveOrUpdate(product);
    }

    public static ProductService getProductService() {
        return productService;
    }
}
