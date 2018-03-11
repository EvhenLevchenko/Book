package dao.realization;

import domain.Book;

import java.util.List;

public interface BookDAO {
    Book addBook(Book book);

    List<Book> getAll();
}
