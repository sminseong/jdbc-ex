package com.ssg.jdbcex.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
