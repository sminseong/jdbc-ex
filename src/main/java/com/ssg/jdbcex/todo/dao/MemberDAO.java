package com.ssg.jdbcex.todo.dao;

import com.ssg.jdbcex.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select * from tbl_member where mid = ? and mpw = ?";
        MemberVO vo = new MemberVO();

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, mid);
        ps.setString(2, mpw);
        @Cleanup ResultSet rs = ps.executeQuery();

        rs.next();
        vo = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .build();

        return vo;
    }

    public void updateUuid(String mid, String uuid) throws Exception {
        String sql = "UPDATE tbl_member SET uuid = ? WHERE mid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uuid);
        ps.setString(2, mid);
        ps.executeUpdate();
    }

    public MemberVO selectUuid(String uuid) throws Exception {
        String sql = "select * from tbl_member where uuid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uuid);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();

        MemberVO vo = MemberVO.builder()
                .mid(rs.getString(1))
                .mpw(rs.getString(2))
                .mname(rs.getString(3))
                .uuid(rs.getString(4))
                .build();
        return vo;
    }
}
