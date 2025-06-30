package com.example.markdowneditor.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteReqDTO {
    private String title;
    private String content;
    private Date createdDate;
}
