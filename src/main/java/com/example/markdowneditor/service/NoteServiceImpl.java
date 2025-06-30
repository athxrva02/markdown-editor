package com.example.markdowneditor.service;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.dto.response.NoteResponseDTO;

import java.util.List;

public class NoteServiceImpl implements NotesService{
    @Override
    public void createNote(CreateNoteReqDTO createNoteReqDTO) {

    }

    @Override
    public String checkGrammar(String content) {
        return "";
    }

    @Override
    public List<NoteResponseDTO> getAllNotes() {
        return List.of();
    }

    @Override
    public String getMarkdownNote() {
        return "";
    }
}
