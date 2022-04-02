package com.petrov.servlets;

import com.petrov.controller.dto.ProductDto;
import com.petrov.service.CategoryService;
import com.petrov.service.ProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

    @Inject
    CategoryService categoryService;

    @Inject
    ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> products = new ArrayList<>();
        for (ProductDto productDto : productService.findAll()) {
            products.add(productDto.getTitle() + ": " + categoryService.findById(productDto.getCategoryDto().getId()).getTitle());
        }

        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);

    }
}
