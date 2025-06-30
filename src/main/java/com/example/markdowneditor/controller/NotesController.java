package com.example.markdowneditor.controller;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.dto.response.CommonResponse;
import com.example.markdowneditor.service.NotesService;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("notes")
public class NotesController {

    private NotesService notesService;

    public CommonResponse createNote(@RequestBody CreateNoteReqDTO createNoteReqDTO) {
        ThreadContext.put("API", "createNote");
        Note
    }
}
