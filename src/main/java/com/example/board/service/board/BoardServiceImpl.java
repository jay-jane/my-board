package com.example.board.service.board;

import com.example.board.repository.BoardCountReqDto;
import com.example.board.repository.BoardModiReqDto;
import com.example.board.repository.BoardRegistReqDto;
import com.example.board.util.RequestList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public int registPost(BoardRegistReqDto boardRegistReqDto) {
        return boardMapper.registPost(boardRegistReqDto);
    }

    @Override
    public int modifyPost(BoardModiReqDto reqDto) {
        return boardMapper.modifyPost(reqDto);
    }

    @Override
    public int deletePost(String boardId) {
        return boardMapper.deletePost(boardId);
    }

    @Override
    public ResponseEntity<?> getBoardDetail(String boardId) {
        if(boardMapper.getBoardDetail(boardId).isDeleted()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제된 글입니다");
        }
        boardMapper.getPostView(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(boardMapper.getBoardDetail(boardId));
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
