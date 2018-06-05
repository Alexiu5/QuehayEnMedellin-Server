package com.project.event.server.Service;

import com.project.event.server.Domain.Dto.CommentDto;
import com.project.event.server.Domain.Report.CommentReport;

import java.util.List;

public interface CommentService {
    List<CommentReport> getAllComments ();
    List<CommentReport> getCommentsByEvent (Long eventId);
    int createComment (CommentDto commentDto);
    CommentReport getCommentById (Long id);
    int updateComment (CommentDto commentDto);
    void deleteComment (Long id);
}
