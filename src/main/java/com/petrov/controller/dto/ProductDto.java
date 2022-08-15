package com.petrov.controller.dto;

import java.math.BigDecimal;

public class ProductDto {

    private Long id;

    private String code;

    private String url;

    private String title;

    private CategoryDto categoryDto;

    private Long orderId;

    private BigDecimal price;

    public ProductDto() {
    }

    public ProductDto(Long id, String code, String title, String url, CategoryDto categoryDto, BigDecimal price) {
        this.id = id;
        this.code = code;
        this.url = url;
        this.title = title;
        this.categoryDto = categoryDto;
        this.price = price;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
