package com.example.board.service.board;

import com.example.board.repository.BoardCountReqDto;
import com.example.board.repository.BoardListResDto;
import com.example.board.repository.BoardRegistReqDto;
import com.example.board.util.RequestList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public int registPost(BoardRegistReqDto boardRegistReqDTO) {
        return boardMapper.registPost(boardRegistReqDTO);
    }

    @Override
    public List<BoardListResDto> getBoardContent() {
        return boardMapper.getBoardContent();
    }

    @Override
    public BoardListResDto getBoardDetail(String boardId) {
        return boardMapper.getBoardDetail(boardId);
    }

    @Override
    public Page<Map<String, Object>> getBoardList(BoardCountReqDto dto, Pageable pageable) {

        RequestList<?> requestList = RequestList.builder()
                .data(dto)
                .pageable(pageable)
                .build();
        List<Map<String, Object>> content = boardMapper.getBoardList(requestList);
        int total = boardMapper.getBoardListCount(dto);
        return new PageImpl<>(content, pageable, total);
    }
}