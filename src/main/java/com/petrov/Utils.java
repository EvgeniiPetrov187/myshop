package com.petrov;

import com.petrov.controller.dto.CategoryDto;
import com.petrov.controller.dto.ProductDto;
import com.petrov.entity.Category;
import com.petrov.entity.Product;

public class Utils {

    public static ProductDto mapProduct(Product product) {
        return new ProductDto(product.getId(),
                product.getCode(),
                product.getTitle(),
                product.getUrl(),
                mapCategoryDto(product.getCategory()),
                product.getPrice());
    }

    public static Product mapProductDto(ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getCode(),
                productDto.getTitle(),
                productDto.getUrl(),
                mapCategory(productDto.getCategoryDto()),
                productDto.getPrice());
    }

    public static Category mapCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getTitle());
    }

    public static CategoryDto mapCategoryDto(Category category) {
        if (category != null) {
            return new CategoryDto(category.getId(), category.getTitle());
        } else {
            return null;
        }
    }
}
