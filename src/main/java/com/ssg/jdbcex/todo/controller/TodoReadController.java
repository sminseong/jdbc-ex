package com.ssg.jdbcex.todo.controller;

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet ........ Read .........");
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);
        req.setAttribute("dto", dto);

        //cookie 추가
        Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
        String todoListStr = viewTodoCookie.getValue();
        boolean exists = false;
        if (todoListStr != null && todoListStr.indexOf(tno + "-") >= 0) {
            exists = true;
        }

        log.info("exists:" + exists);
        if (!exists) {
            todoListStr += tno + "-";
            viewTodoCookie.setValue(todoListStr);
            viewTodoCookie.setMaxAge(60*60*24);
            viewTodoCookie.setPath("/");
            resp.addCookie(viewTodoCookie);
        }

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        Cookie cookie = null;

        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if(c.getName().equals(cookieName)) {
                    cookie = c;
                    break;
                }
            }
        }
        if (cookie == null) {
            cookie = new Cookie(cookieName, "");
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24);
        }
        return cookie;
    }
}
