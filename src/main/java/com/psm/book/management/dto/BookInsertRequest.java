package com.psm.book.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInsertRequest {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}
