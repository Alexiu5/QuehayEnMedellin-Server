package com.project.event.server.Dao;

import com.project.event.server.Domain.Dto.TagDto;
import com.project.event.server.Domain.Report.TagReport;

import java.util.List;

public interface TagDao {
    List<TagReport> getAllTags ();
    int createTag (TagDto tagDto);
    int createTagEvent (int eventId, List<Long> tagList);
    TagReport getTagById (Long id);
    int updateTag (TagDto tagDto);
    void deleteTag (Long id);
}
