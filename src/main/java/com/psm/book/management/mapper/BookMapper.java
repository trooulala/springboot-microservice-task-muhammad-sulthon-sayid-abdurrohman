package com.psm.book.management.mapper;

import com.psm.book.management.dto.BookTitleUpdateRequest;
import com.psm.book.management.dto.BookUpsertRequest;
import com.psm.book.management.dto.BookResponse;
import com.psm.book.management.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookUpsertRequest dto);

    BookResponse toDto(Book book);

    List<BookResponse> toDtoList(List<Book> books);

    void updateEntityFromDto(@MappingTarget Book book, BookUpsertRequest dto);

    void updateTitleFromDto(@MappingTarget Book book, BookTitleUpdateRequest dto);
}
