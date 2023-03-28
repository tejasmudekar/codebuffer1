package com.codebuffer1.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage
{

    private HttpStatus status;
    private String message;
}
