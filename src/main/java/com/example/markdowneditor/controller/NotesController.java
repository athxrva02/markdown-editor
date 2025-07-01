package com.example.markdowneditor.controller;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.dto.response.CommonResponse;
import com.example.markdowneditor.enums.ResponseStatus;
import com.example.markdowneditor.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("notes")
public class NotesController {

    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping()
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

    @PostMapping("/check-grammar")
    public CommonResponse checkGrammar(@RequestBody String content) {
        ThreadContext.put("API", "checkGrammar");
        try {
            String response = notesService.checkGrammar(content);
            return new CommonResponse(ResponseStatus.SUCCESS, response, "Grammar check successful");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new CommonResponse(ResponseStatus.ERROR, null, e.getMessage());
        } finally {
            ThreadContext.remove("API");
        }
    }

    @PostMapping("/get-markdown")
    public CommonResponse getMarkdown(@RequestBody String content) {
        ThreadContext.put("API", "getMarkdown");
        try {
            String response = notesService.getMarkdownNote(content);
            return new CommonResponse(ResponseStatus.SUCCESS, response, "Note converted to markdown successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new CommonResponse(ResponseStatus.ERROR, null, e.getMessage());
        } finally {
            ThreadContext.remove("API");
        }
    }

}
