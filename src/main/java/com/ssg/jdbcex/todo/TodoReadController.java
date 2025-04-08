package com.ssg.jdbcex.todo;

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet ........ Read .........");
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);
        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
    }
}
