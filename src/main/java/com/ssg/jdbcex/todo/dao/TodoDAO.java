package com.ssg.jdbcex.todo.dao;

import com.ssg.jdbcex.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DB로부터 시간 얻어오는 간단한 기능 구현
public class TodoDAO {

    public String getTime() {
        String now = null;
        try(Connection conn = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement ps = conn.prepareStatement("select now()");
            ResultSet rs = ps.executeQuery()) {
            rs.next();
            now = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }

    //tbl_todo 테이블에 todo를 넣는 insert(TodoVO vo)
    public void insert(TodoVO vo) throws SQLException {
        //쿼리문
        String sql = "INSERT INTO tbl_todo(title, dueDate, finished) VALUES (?, ?, ?)";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vo.getTitle());
        ps.setDate(2, Date.valueOf(vo.getDueDate()));
        ps.setBoolean(3, vo.isFinished());

        ps.executeUpdate();
    }

    public List<TodoVO> selectAll() throws SQLException {
        String sql = "SELECT * FROM tbl_todo";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while (rs.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

            list.add(vo);
        }
        return list;
    }

    //todoVO one delete
    public void deleteOne(long tno) throws SQLException {
        String sql = "DELETE FROM tbl_todo WHERE tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, tno);
        ps.executeUpdate();
    }

    //todoVO one update
    public void updateOne(TodoVO todoVO) throws SQLException {
        String sql = "UPDATE tbl_todo SET title = ?, dueDate = ?, finished = ? WHERE tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, todoVO.getTitle());
        ps.setDate(2, Date.valueOf(todoVO.getDueDate()));
        ps.setBoolean(3, todoVO.isFinished());
        ps.setLong(4, todoVO.getTno());
        ps.executeUpdate();
    }

}
