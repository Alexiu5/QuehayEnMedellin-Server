package com.project.event.server.Service.Impl;

import com.project.event.server.Dao.TagDao;
import com.project.event.server.Domain.Dto.TagDto;
import com.project.event.server.Domain.Report.TagReport;
import com.project.event.server.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public List<TagReport> getAllTags() {
        return tagDao.getAllTags();
    }

    @Override
    public int createTag(TagDto tagDto) {
        return tagDao.createTag(tagDto);
    }

    @Override
    public TagReport getTagById(Long id) {
        return tagDao.getTagById(id);
    }

    @Override
    public int updateTag(TagDto tagDto) {
        return tagDao.updateTag(tagDto);
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteTag(id);
    }
}
