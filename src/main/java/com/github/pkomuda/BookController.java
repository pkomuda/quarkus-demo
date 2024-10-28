package com.github.pkomuda;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import java.util.List;

@Slf4j
@Path("/books")
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

    @ServerExceptionMapper
    public RestResponse<String> handleException(Exception e) {
        log.error("Handled exception", e);
        return RestResponse.status(RestResponse.Status.BAD_REQUEST, e.getMessage());
    }
}
