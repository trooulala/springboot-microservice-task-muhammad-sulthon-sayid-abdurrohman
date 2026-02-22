package com.psm.book.management.controller;

import com.psm.book.management.dto.BookTitleUpdateRequest;
import com.psm.book.management.dto.BookUpsertRequest;
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
    public ResponseEntity<BookResponse> addNewBook(@Valid @RequestBody BookUpsertRequest dto) {
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

    @PutMapping("{id}")
    public ResponseEntity<BookResponse> updateBookById(@PathVariable Long id, @Valid @RequestBody BookUpsertRequest dto) {
        BookResponse response = bookService.updateBookById(id, dto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<BookResponse> updateBookTitleById(@PathVariable Long id, @Valid @RequestBody BookTitleUpdateRequest dto) {
        BookResponse response = bookService.updateBookTitleById(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
