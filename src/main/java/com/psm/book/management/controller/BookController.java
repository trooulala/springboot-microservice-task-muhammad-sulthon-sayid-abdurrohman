package com.psm.book.management.controller;

import com.psm.book.management.dto.BookInsertRequest;
import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        List<BookResponse> responses = bookService.findAllBook();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable Long id) {
        BookResponse response = bookService.findBookById(id);

        return ResponseEntity.ok(response);
    }
}
