package com.petrov.servlets;

import com.petrov.controller.dto.CategoryDto;
import com.petrov.controller.dto.ProductDto;
import com.petrov.jms.ConsumerFirst;
import com.petrov.jms.ConsumerSecond;
import com.petrov.jms.Producer;
import com.petrov.service.CategoryService;
import com.petrov.service.ProductService;

import javax.ejb.Schedule;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(Producer.class.getName());

    @Inject
    CategoryService categoryService;

    @Inject
    ProductService productService;

    @Inject
    Producer producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> products = new ArrayList<>();
        for (ProductDto productDto : productService.findAll()) {
            CategoryDto categoryDto = productDto.getCategoryDto();
            products.add(productDto.getTitle() + ": " + (categoryDto != null ? categoryDto.getTitle() : "No Category"));
        }

        producer.produceMessage();
        req.setAttribute("products", products);
        req.setAttribute("messages-first", ConsumerFirst.messages);
        req.setAttribute("messages-second", ConsumerSecond.messages);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    @Schedule(hour = "*", minute = "*", second = "*/2", persistent = false)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        producer.produceMessage();
        doGet(req, resp);
    }
}
