package com.project.event.server.Controller;

import com.project.event.server.Domain.Dto.TagDto;
import com.project.event.server.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag.list")
    @ResponseBody
    public ResponseEntity getAllTags (HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("tags", tagService.getAllTags());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/tag.create")
    @ResponseBody
    public ResponseEntity createTag (@RequestBody @Valid TagDto tagDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", tagService.createTag(tagDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/tag.update")
    @ResponseBody
    public ResponseEntity updateTag (@RequestBody @Valid TagDto tagDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", tagService.updateTag(tagDto));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/tag.{id}")
    @ResponseBody
    public ResponseEntity getTagById (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("tag", tagService.getTagById(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/tag.remove.{id}")
    @ResponseBody
    public ResponseEntity removeTag (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        tagService.deleteTag(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
