package com.example.markdowneditor.dto.response;

import com.example.markdowneditor.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {
    private ResponseStatus status;
    private Object data;
    private String message;
}
