package com.ssg.jdbcex.todo.controller;

import com.ssg.jdbcex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name="todoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("remove............post");
        req.setCharacterEncoding("UTF-8");
        long tno = Long.parseLong(req.getParameter("tno"));

        try {
            todoService.remove(tno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/todo/list");
    }
}
