package service;

import dao.realization.hibernate.BookDAOImpl;
import domain.Book;
import dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private BookDAOImpl bookDAO = new BookDAOImpl();

    public BookDto addBook(BookDto bookDto) {
        Book book = bookDAO.addBook(BookDto .fromDto(bookDto));
        return BookDto.toDto(book);
    }

    public List<BookDto> getAll() {
        return bookDAO.getAll().stream()
                .map(b -> BookDto.toDto(b))
                .collect(Collectors.toList());
    }
}
