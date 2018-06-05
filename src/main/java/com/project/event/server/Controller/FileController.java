package com.project.event.server.Controller;

import com.project.event.server.Domain.Dto.FileDto;
import com.project.event.server.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/file.list")
    @ResponseBody
    public ResponseEntity getAllFiles (HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("files", fileService.getAllFiles());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/file.list.{id}")
    @ResponseBody
    public ResponseEntity getFileByEvent (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("files", fileService.getFilesByEvent(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/file.create")
    @ResponseBody
    public ResponseEntity createFile (@RequestBody @Valid FileDto fileDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", fileService.createFile(fileDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/file.{id}")
    @ResponseBody
    public ResponseEntity getFileById (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("file", fileService.getFileById(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/remove.file.{id}")
    @ResponseBody
    public ResponseEntity removeFile (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        fileService.deleteFile(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
