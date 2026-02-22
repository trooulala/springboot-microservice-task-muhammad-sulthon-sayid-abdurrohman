package com.psm.book.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpsertRequest {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}
