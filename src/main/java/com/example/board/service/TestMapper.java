package com.example.board.service;

import com.example.board.command.TestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    public TestVO selectTest(@Param("id") long id);

}
