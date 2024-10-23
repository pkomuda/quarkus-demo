package com.github.pkomuda;

import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta-cdi")
public interface BookMapper {

    Book toEntity(BookDto dto);
    BookDto toDto(Book entity);
}
