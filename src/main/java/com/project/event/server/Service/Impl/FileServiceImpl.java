package com.project.event.server.Service.Impl;

import com.project.event.server.Dao.FileDao;
import com.project.event.server.Domain.Dto.FileDto;
import com.project.event.server.Domain.Report.FileReport;
import com.project.event.server.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public List<FileReport> getAllFiles() {
        return fileDao.getAllFiles();
    }

    @Override
    public List<FileReport> getFilesByEvent(Long id) {
        return fileDao.getFilesByEvent(id);
    }

    @Override
    public int createFile(FileDto fileDto) {
        return fileDao.createFile(fileDto);
    }

    @Override
    public FileReport getFileById(Long id) {
        return fileDao.getFileById(id);
    }

    @Override
    public void deleteFile(Long id) {
        fileDao.deleteFile(id);
    }
}
