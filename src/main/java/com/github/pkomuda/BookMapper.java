package com.github.pkomuda;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BookMapper {

    Book toEntity(BookDto dto);
    BookDto toDto(Book entity);
    List<BookDto> toDtos(List<Book> entities);
}
