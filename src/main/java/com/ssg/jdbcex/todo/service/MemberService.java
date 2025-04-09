package com.ssg.jdbcex.todo.service;

import com.ssg.jdbcex.todo.dao.MemberDAO;
import com.ssg.jdbcex.todo.domain.MemberVO;
import com.ssg.jdbcex.todo.dto.MemberDTO;
import com.ssg.jdbcex.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;
    private ModelMapper modelMapper;
    private MemberDAO memberDAO;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO memberVO = memberDAO.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;
    }

    public void updateUuid(String mid, String uuid) throws Exception {
        memberDAO.updateUuid(mid, uuid);
    }

    public MemberDTO getByUuid(String uuid) throws Exception {
        MemberVO memberVO = memberDAO.selectUuid(uuid);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }
}
