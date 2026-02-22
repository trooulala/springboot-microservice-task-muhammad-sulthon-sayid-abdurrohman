package com.psm.book.management.service;


import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.dto.BookTitleUpdateRequest;
import com.psm.book.management.dto.BookUpsertRequest;
import com.psm.book.management.entity.Book;
import com.psm.book.management.error.exception.ResourceNotFound;
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

    public BookResponse addNewBook(BookUpsertRequest dto) {
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
                .orElseThrow(() -> new ResourceNotFound("No Book with Id " + id));

        return bookMapper.toDto(book);
    }

    public BookResponse updateBookById(Long id, BookUpsertRequest dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No Book with Id " + id));

        bookMapper.updateEntityFromDto(book, dto);
        var saved = bookRepository.save(book);

        return bookMapper.toDto(saved);
    }

    public BookResponse updateBookTitleById(Long id, BookTitleUpdateRequest dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No Book with Id " + id));

        bookMapper.updateTitleFromDto(book, dto);
        var saved = bookRepository.save(book);

        return bookMapper.toDto(saved);
    }

    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No Book with Id " + id));

        bookRepository.delete(book);
    }
}
