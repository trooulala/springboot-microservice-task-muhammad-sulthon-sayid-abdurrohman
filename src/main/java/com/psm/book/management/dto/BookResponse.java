package com.psm.book.management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}
