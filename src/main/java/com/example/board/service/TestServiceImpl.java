package com.example.board.service;

import com.example.board.command.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestVO selectTest(long id) {
        return testMapper.selectTest(id);
    }
}
