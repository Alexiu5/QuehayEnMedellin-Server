package com.project.event.server.Controller;

import com.project.event.server.Domain.Dto.EventTypeDto;
import com.project.event.server.Service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class EventTypeController {
    @Autowired
    private EventTypeService eventTypeService;

    @GetMapping("/event.type.list")
    @ResponseBody
    public ResponseEntity getAllEventTypes (HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("eventTypes", eventTypeService.getAllEventTypes());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/event.type.create")
    @ResponseBody
    public ResponseEntity createEventType (@RequestBody @Valid EventTypeDto eventTypeDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", eventTypeService.createEventType(eventTypeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/event.type.update")
    @ResponseBody
    public ResponseEntity updateEventType (@RequestBody @Valid EventTypeDto eventTypeDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", eventTypeService.updateEventType(eventTypeDto));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/event.type.{id}")
    @ResponseBody
    public ResponseEntity getEventTypeById (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("eventType", eventTypeService.getEventTypeById(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/event.type.remove.{id}")
    @ResponseBody
    public ResponseEntity removeEventType (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        eventTypeService.deleteEventType(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
