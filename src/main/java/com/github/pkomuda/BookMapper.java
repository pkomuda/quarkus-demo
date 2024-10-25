package com.github.pkomuda;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
interface BookMapper {

    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDto dto);

    BookDto toDto(Book entity);

    List<BookDto> toDtos(List<Book> entities);
}
