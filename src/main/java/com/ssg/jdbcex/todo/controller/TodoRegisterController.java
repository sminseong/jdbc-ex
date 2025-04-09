package com.ssg.jdbcex.todo.controller;

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name="todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("register..........get");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("register.........post");
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));

        TodoDTO todoDTO = TodoDTO.builder()
                .title(title)
                .dueDate(dueDate)
                .build();
        try {
            todoService.register(todoDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/todo/list");
    }
}
