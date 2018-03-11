package dao.realization.hibernate;

import dao.realization.CarDAO;
import domain.Car;
import org.hibernate.Session;

import java.util.List;

public class CarDAOImpl extends DataBaseCon implements CarDAO {

    @Override
    public Car addCar(Car car) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
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
        return car;
    }

    @Override
    public List<Car> getAll() {
        Session session = null;
        List<Car> cars = null;
        try {
            session = getSessionFactory().openSession();
            cars = (List<Car>) session.createQuery("from Car").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cars;
    }
}
