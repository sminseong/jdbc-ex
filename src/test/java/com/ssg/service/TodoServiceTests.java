package com.ssg.service;

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void setUp() throws Exception {
        todoService = TodoService.INSTANCE;
    }
    @Test
    public void testRegister() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Sample test Mapper Register todo VO2_2")
                .dueDate(LocalDate.now())
                .build();

        todoService.register(todoDTO);

        log.info("=====================================");
    }
}
