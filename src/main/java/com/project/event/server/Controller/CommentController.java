package com.project.event.server.Controller;

import com.project.event.server.Domain.Dto.CommentDto;
import com.project.event.server.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment.list")
    @ResponseBody
    public ResponseEntity getAllComments (HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("comments", commentService.getAllComments());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/comment.list.{id}")
    @ResponseBody
    public ResponseEntity getCommentsByEvent (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("comments", commentService.getCommentsByEvent(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/comment.create")
    @ResponseBody
    public ResponseEntity createComment (@RequestBody @Valid CommentDto commentDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", commentService.createComment(commentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/comment.update")
    @ResponseBody
    public ResponseEntity updateComment (@RequestBody @Valid CommentDto commentDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", commentService.updateComment(commentDto));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/comment.{id}")
    @ResponseBody
    public ResponseEntity getCommentById (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("comment", commentService.getCommentById(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/remove.comment.{id}")
    @ResponseBody
    public ResponseEntity removeComment (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
