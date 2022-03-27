package com.petrov;

import com.petrov.controller.dto.ProductDto;
import com.petrov.service.CategoryService;
import com.petrov.service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class ExampleBean implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private CategoryService categoryService;

    private String title;

    private Long category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getAllProducts() {
        return productService.findAll().stream()
                .map(product -> product.getTitle()+ " " + product.getCategoryDto().getTitle()).collect(Collectors.joining());
    }

    public void save(){
        productService.saveOrUpdate(new ProductDto(null, getTitle(), categoryService.findById(getCategory())));
    }
}
