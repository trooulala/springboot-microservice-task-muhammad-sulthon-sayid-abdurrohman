package com.psm.book.management.controller;

import com.psm.book.management.dto.BookInsertRequest;
import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<BookResponse> addNewBook(@Valid @RequestBody BookInsertRequest dto) {
        BookResponse response = bookService.addNewBook(dto);
        return ResponseEntity.ok(response);
    }
}
