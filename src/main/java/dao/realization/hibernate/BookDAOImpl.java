package dao.realization.hibernate;

import dao.realization.BookDAO;
import domain.Book;
import org.hibernate.Session;

import java.util.List;


public class BookDAOImpl extends DataBaseCon implements BookDAO {


    @Override
    public Book addBook(Book book) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        Session session = null;
        List<Book> books = null;
        try {
            session = getSessionFactory().openSession();
            books = (List<Book>) session.createQuery("from Book").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return books;
    }
}
