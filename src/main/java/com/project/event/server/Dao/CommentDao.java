package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.CommentDto;
import com.project.event.server.Domain.Report.CommentReport;

import java.util.List;

public interface CommentDao {
    List<CommentReport> getAllComments ();
    List<CommentReport> getCommentsByEvent (Long eventId);
    int createComment (CommentDto commentDto);
    CommentReport getCommentById (Long id);
    int updateComment (CommentDto commentDto);
    void deleteComment (Long id);
}
