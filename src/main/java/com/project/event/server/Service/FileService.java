package com.project.event.server.Service;

import com.project.event.server.Domain.Dto.FileDto;
import com.project.event.server.Domain.Report.FileReport;

import java.util.List;

public interface FileService {
    List<FileReport> getAllFiles ();
    List<FileReport> getFilesByEvent (Long id);
    int createFile (FileDto fileDto);
    FileReport getFileById (Long id);
    void deleteFile (Long id);
}
