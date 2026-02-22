package com.psm.book.management.service;

import com.psm.book.management.dto.BookInsertRequest;
import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.entity.Book;
import com.psm.book.management.mapper.BookMapper;
import com.psm.book.management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookResponse addNewBook(BookInsertRequest dto) {
        Book book = bookMapper.toEntity(dto);
        var saved = bookRepository.save(book);

        return bookMapper.toDto(saved);
    }

    public List<BookResponse> findAllBook() {
        List<Book> books = bookRepository.findAll();

        return bookMapper.toDtoList(books);
    }

    public BookResponse findBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Book with Id " + id));

        return bookMapper.toDto(book);
    }
}
