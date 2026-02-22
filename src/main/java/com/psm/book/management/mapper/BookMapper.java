package com.psm.book.management.mapper;

import com.psm.book.management.dto.BookInsertRequest;
import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity (BookInsertRequest dto);

    BookResponse toDto (Book book);
}
