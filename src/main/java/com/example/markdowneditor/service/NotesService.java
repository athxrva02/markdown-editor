package com.example.markdowneditor.service;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.dto.response.NoteResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {
    void createNote(CreateNoteReqDTO createNoteReqDTO);
    String checkGrammar(String content);
    List<NoteResponseDTO> getAllNotes();
    String getMarkdownNote();
}
