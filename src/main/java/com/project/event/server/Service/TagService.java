package com.project.event.server.Service;

import com.project.event.server.Domain.Dto.TagDto;
import com.project.event.server.Domain.Report.TagReport;

import java.util.List;

public interface TagService {
    List<TagReport> getAllTags ();
    int createTag (TagDto tagDto);
    TagReport getTagById (Long id);
    int updateTag (TagDto tagDto);
    void deleteTag (Long id);
}
