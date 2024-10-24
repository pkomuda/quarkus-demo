package com.github.pkomuda;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public void addBook(BookDto bookDto) {
        bookRepository.persistAndFlush(bookMapper.toEntity(bookDto));
    }

    public BookDto getBook(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<BookDto> getAllBooks() {
        return bookMapper.toDtos(bookRepository.listAll());
    }
}
