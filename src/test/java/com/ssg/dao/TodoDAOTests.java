package com.ssg.dao;

import com.ssg.jdbcex.todo.dao.TodoDAO;
import com.ssg.jdbcex.todo.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }
    @Test
    public void testTime() throws SQLException {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws SQLException {
        TodoVO vo = TodoVO.builder()
                .title("Sample test")
                .dueDate(LocalDate.now())
                .build();

        TodoDAO dao = new TodoDAO();
        dao.insert(vo);
    }

    @Test
    public void testList() throws SQLException {
        List<TodoVO> voList = todoDAO.selectAll();
        voList.forEach(System.out::println);
    }

    @Test
    public void testDelete() throws SQLException {
        todoDAO.deleteOne(2);
    }

    @Test
    public void testUpdate() throws SQLException {
        TodoVO todoVO = TodoVO.builder()
                .title("Update Title")
                .dueDate(LocalDate.now())
                .finished(true)
                .tno(1)
                .build();

        todoDAO.updateOne(todoVO);
    }

}
