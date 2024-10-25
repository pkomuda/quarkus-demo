package com.github.pkomuda;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Transactional
@ApplicationScoped
class BookRepository implements PanacheRepository<Book> {

    public Optional<Book> findByIsbn(String isbn) {
        return find("isbn", isbn).singleResultOptional();
    }
}
