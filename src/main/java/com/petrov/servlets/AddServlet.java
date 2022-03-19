package com.petrov.servlets;

import com.petrov.controller.dto.CategoryDto;
import com.petrov.controller.dto.ProductDto;
import com.petrov.dao.ProductDao;
import com.petrov.dao.ProductDaoImpl;
import com.petrov.entity.Category;
import com.petrov.entity.Product;
import com.petrov.service.CategoryService;
import com.petrov.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    ProductService productService = ProductService.getProductService();
    CategoryService categoryService = CategoryService.getCategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> products = productService.findAll().stream().map(ProductDto::getTitle).collect(Collectors.toList());
        req.setAttribute("products", products);

        List<String> categories = categoryService.findAll().stream().map(CategoryDto::getTitle).collect(Collectors.toList());
        req.setAttribute("categories", categories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String category = req.getParameter("category");

        CategoryDto categoryDto = categoryService.findByTitle(category);
        ProductDto productDto = new ProductDto(null, title, categoryDto);
        productService.saveOrUpdate(productDto);

        req.setAttribute("title", title);
        doGet(req, resp);
    }
}
