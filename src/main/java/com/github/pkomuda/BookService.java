package com.github.pkomuda;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@Slf4j
@Transactional
@ApplicationScoped
@RequiredArgsConstructor
class BookService {

    @ConfigProperty(name = "custom.property")
    String customPropertyInjected;
    private final String customProperty = ConfigProvider.getConfig().getValue("custom.property", String.class);
    private static final String customPropertyStatic = ConfigProvider.getConfig().getValue("custom.property", String.class);

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
        log.info(customPropertyInjected);
        log.info(customProperty);
        log.info(customPropertyStatic);
        return bookMapper.toDtos(bookRepository.listAll());
    }
}
