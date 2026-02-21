package com.psm.book.management.service;

import com.psm.book.management.dto.BookInsertRequest;
import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.entity.Book;
import com.psm.book.management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponse addNewBook(BookInsertRequest dto) {
        Book book = bookMapper.toEntity(dto);
    }
}
