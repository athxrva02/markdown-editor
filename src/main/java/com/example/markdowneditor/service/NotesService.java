package com.example.markdowneditor.service;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.entity.Note;

import java.util.List;

public interface NotesService {
    void createNote(CreateNoteReqDTO createNoteReqDTO);
    String checkGrammar(String content);
    List<Note> getAllNotes();
    String getMarkdownNote(String content);
}
