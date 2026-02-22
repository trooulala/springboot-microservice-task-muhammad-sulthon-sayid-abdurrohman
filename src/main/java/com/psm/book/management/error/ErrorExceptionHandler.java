package com.psm.book.management.error;

import com.psm.book.management.error.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorMessageResponse<Object>> handleResourceNotFound(ResourceNotFound e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        var errorMessage = ErrorMessageResponse.builder()
                .status(httpStatus)
                .message(e.getMessage())
                .errors(null)
                .build();

        return ResponseEntity.status(httpStatus).body(errorMessage);
    }
}
