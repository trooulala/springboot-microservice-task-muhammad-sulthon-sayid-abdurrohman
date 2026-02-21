package com.psm.book.management.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookInsertRequest {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}
