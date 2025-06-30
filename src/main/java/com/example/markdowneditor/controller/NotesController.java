package com.example.markdowneditor.controller;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.dto.response.CommonResponse;
import com.example.markdowneditor.enums.ResponseStatus;
import com.example.markdowneditor.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("notes")
public class NotesController {

    private NotesService notesService;

    public CommonResponse createNote(@RequestBody CreateNoteReqDTO createNoteReqDTO) {
        ThreadContext.put("API", "createNote");
        try {
            notesService.createNote(createNoteReqDTO);
            return new CommonResponse(ResponseStatus.SUCCESS, null, "Note created successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new CommonResponse(ResponseStatus.ERROR, null, e.getMessage());
        } finally {
            ThreadContext.remove("API");
        }
    }
}
