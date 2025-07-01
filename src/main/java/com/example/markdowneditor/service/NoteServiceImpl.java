package com.example.markdowneditor.service;

import com.example.markdowneditor.dto.request.CreateNoteReqDTO;
import com.example.markdowneditor.entity.Note;
import com.example.markdowneditor.repository.NoteRepository;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class NoteServiceImpl implements NotesService{

    private NoteRepository noteRepository;

    @Override
    public void createNote(CreateNoteReqDTO createNoteReqDTO) {
        Note saveNote = convertCreateDTOToEntity(createNoteReqDTO);
        noteRepository.save(saveNote);
    }


    @Override
    public String checkGrammar(String content) {
        JLanguageTool langTool = new JLanguageTool(Languages.getLanguageForShortCode("en-GB"));
        StringBuilder result = new StringBuilder();
        try {
            List<RuleMatch> matches = langTool.check(content);
            if (matches.isEmpty()) {
                return content;
            }
            for (RuleMatch match : matches) {
                result.append("Potential error at characters ")
                        .append(match.getFromPos())
                        .append("-")
                        .append(match.getToPos())
                        .append(": ")
                        .append(match.getMessage())
                        .append("\nSuggested correction(s): ")
                        .append(match.getSuggestedReplacements())
                        .append("\n\n");
            }
        } catch (IOException e) {
            return "Error checking grammar: " + e.getMessage();
        }
        return result.toString();
    }


    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public String getMarkdownNote(String content) {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        Node document = parser.parse(content);
        return renderer.render(document);
    }

    private Note convertCreateDTOToEntity(CreateNoteReqDTO createNoteReqDTO) {
        Note note = new Note();
        note.setTitle(createNoteReqDTO.getTitle());
        note.setContent(createNoteReqDTO.getContent());
        note.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        note.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        return note;
    }
}
