package dao.realization.hibernate;

import dao.realization.AutorDAO;
import domain.Autor;
import org.hibernate.Session;

import java.util.List;

public class AutorDAOImpl extends DataBaseCon implements AutorDAO {


    public void saveAuthor(Autor autor) {
        Session sessionObj = null;
        try {
            sessionObj = getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(autor);
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");
            sessionObj.getTransaction().commit();
        } catch (Exception e) {
            if (sessionObj.getTransaction() != null) {
                System.err.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public List<Autor> getAllAutors() {
        Session session = null;
        List<Autor> authors = null;
        try {
            session = getSessionFactory().openSession();
            authors = (List<Autor>) session.createQuery("from Autor").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return authors;
    }
}
