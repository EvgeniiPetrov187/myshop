package com.petrov.controller.dto;

public class ProductDto {

        private Long id;

        private String title;

        private CategoryDto categoryDto;

        private Long orderId;

    public ProductDto(Long id, String title, CategoryDto categoryDto) {
        this.id = id;
        this.title = title;
        this.categoryDto = categoryDto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
