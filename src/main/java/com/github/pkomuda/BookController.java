package com.github.pkomuda;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Path("/books")
@ApplicationScoped
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class BookController {

    private final BookService bookService;

    @POST
    public void addBook(BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @GET
    @Path("/{isbn}")
    public BookDto getBook(@PathParam("isbn") String isbn) {
        return bookService.getBook(isbn);
    }

    @GET
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }
}
