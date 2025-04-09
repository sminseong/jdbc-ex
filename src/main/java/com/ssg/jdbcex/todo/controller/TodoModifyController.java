package com.ssg.jdbcex.todo.controller;

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name="todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("modify...........get");
        long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO todoDTO = TodoService.INSTANCE.get(tno);
        req.setAttribute("dto", todoDTO);
        req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       log.info("modify............post");
       req.setCharacterEncoding("UTF-8");
       long tno = Long.parseLong(req.getParameter("tno"));
       String title = req.getParameter("title");
       LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));
       boolean finished = Boolean.parseBoolean(req.getParameter("finished"));

        TodoDTO todoDTO = TodoDTO.builder()
                .tno(tno)
                .title(title)
                .dueDate(dueDate)
                .finished(finished)
                .build();

        try {
            todoService.modify(todoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/todo/list");
    }

}
