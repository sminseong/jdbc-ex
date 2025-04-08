package com.ssg.jdbcex.todo;

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@WebServlet(name="todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet-------list Controller");
//        System.out.println("todo/list");

        try {
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("list", dtoList);

            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            log.error(e);
            throw new ServletException("list error");
        } catch (IOException e) {
            log.error(e);
            throw new IOException("list error");
        } catch (Exception e) {
            log.error(e);
        }
    }
}
