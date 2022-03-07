package com.petrov;

import com.petrov.controller.dto.CategoryDto;
import com.petrov.controller.dto.ProductDto;
import com.petrov.entity.Category;
import com.petrov.entity.Product;

public class Utils {

    public static ProductDto mapProduct(Product product) {
        return new ProductDto(product.getId(), product.getTitle(),  mapCategoryDto(product.getCategory()));
    }

    public static Product mapProductDto(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), mapCategory(productDto.getCategoryDto()));
    }

    public static Category mapCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getTitle());
    }

    public static CategoryDto mapCategoryDto(Category category) {
        return new CategoryDto(category.getId(), category.getTitle());
    }

}
