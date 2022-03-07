//package com.petrov.controller;
//
//import com.petrov.controller.dto.ProductDto;
//import com.petrov.dao.ProductDao;
//
//import javax.ejb.Stateful;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Stateful
//
//public class ProductController {
//
//    private final ProductDao productDao;
//
//    public ProductController(ProductDao productDao) {
//        this.productDao = productDao;
//    }
//
//    public List<ProductDto> findAll() {
//        return productDao.findAll().stream().map(product -> new ProductDto(
////                product.getId(),
////                product.getTitle(),
////                product.getCategory(),
////                product.getOrder()))
//                1L, "KOP"))
//                .collect(Collectors.toList());
//    }
//}
