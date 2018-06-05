package com.project.event.server.Service.Impl;

import com.project.event.server.Dao.CommentDao;
import com.project.event.server.Domain.Dto.CommentDto;
import com.project.event.server.Domain.Report.CommentReport;
import com.project.event.server.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentReport> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public List<CommentReport> getCommentsByEvent (Long eventId) {
        return commentDao.getCommentsByEvent(eventId);
    }

    @Override
    public int createComment(CommentDto commentDto) {
        return commentDao.createComment(commentDto);
    }

    @Override
    public CommentReport getCommentById(Long id) {
        return commentDao.getCommentById(id);
    }

    @Override
    public int updateComment(CommentDto commentDto) {
        return commentDao.updateComment(commentDto);
    }

    @Override
    public void deleteComment(Long id) {
        commentDao.deleteComment(id);
    }
}
