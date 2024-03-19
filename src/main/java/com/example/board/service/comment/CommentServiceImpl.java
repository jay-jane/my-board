package com.example.board.service.comment;

import com.example.board.repository.comment.CommentDeleteReqDto;
import com.example.board.repository.comment.CommentRegistReqDto;
import com.example.board.repository.comment.CommentRegistResDto;
import com.example.board.service.likes.LikesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public CommentRegistResDto registComment(CommentRegistReqDto reqDto) {
        commentMapper.registComment(reqDto);
        return commentMapper.findById(reqDto.getId());
    }

    @Override
    public List<CommentRegistResDto> getCommentList(long boardId) {
        List<CommentRegistResDto> result = commentMapper.getCommentList(boardId);
        for (CommentRegistResDto resDto : result) {
            if (resDto.isDeleted()) {
                resDto.setContent(null);
                resDto.setNickname(null);
                resDto.setRegDate(null);
                resDto.setModDate(null);
            }
        }
        return result;
    }

    @Override
    public int deleteComment(CommentDeleteReqDto reqDto) {
        return commentMapper.deleteComment(reqDto);
    }
}
