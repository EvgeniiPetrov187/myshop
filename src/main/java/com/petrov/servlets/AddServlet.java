package com.petrov.servlets;


import com.petrov.controller.dto.CategoryDto;
import com.petrov.controller.dto.ProductDto;
import com.petrov.jms.ConsumerFirst;
import com.petrov.jms.ConsumerSecond;
import com.petrov.jms.Producer;
import com.petrov.service.CategoryService;
import com.petrov.service.ProductService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Inject
    CategoryService categoryService;

    @Inject
    Producer producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> products = productService.findAll().stream().map(ProductDto::getTitle).collect(Collectors.toList());
        req.setAttribute("products", products);

        List<String> categories = categoryService.findAll().stream().map(CategoryDto::getTitle).collect(Collectors.toList());
        req.setAttribute("categories", categories);

        req.setAttribute("messages-first", ConsumerFirst.messages);
        req.setAttribute("messages-second", ConsumerSecond.messages);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String code = req.getParameter("code");
        String url = req.getParameter("url");
        String price = req.getParameter("price");
        String category = req.getParameter("category");

        CategoryDto categoryDto = categoryService.findByTitle(category);
        ProductDto productDto = new ProductDto(null, code, title, url, categoryDto, new BigDecimal(price));
        productService.saveOrUpdate(productDto);
        producer.produceMessage("Добавлен " + productDto.getTitle());
//        req.setAttribute("messages-first", ConsumerFirst.messages);
//        req.setAttribute("messages-second", ConsumerSecond.messages);

        req.setAttribute("title", title);
        req.setAttribute("code", code);
        req.setAttribute("url", url);
        req.setAttribute("price", price);
        doGet(req, resp);

    }
}
