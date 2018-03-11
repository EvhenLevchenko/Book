

import dao.realization.*;

import dao.realization.hibernate.*;
import domain.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Autor> autors = new ArrayList<Autor>();

        Autor author1 = new Autor();
        author1.setAutorName("Bob");
        autors.add(author1);
        Autor author2 = new Autor();
        author2.setAutorName("Bobbi");
        autors.add(author2);
        Autor author3 = new Autor();
        author3.setAutorName("Bill");
        autors.add(author3);
        Autor author4 = new Autor();
        author4.setAutorName("Bob");
        autors.add(author4);

        AutorDAO autorDAO = new AutorDAOImpl();
        autors.forEach(autorDAO::saveAuthor);


        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setTitle("Волхв");
        book1.getYear();
        book1.setGenre(Genre.FICTION);
        book1.setAutor(author1);
        books.add(book1);
        Book book2 = new Book();
        book2.setTitle("Любовница французского лейтенанта");
        book2.setGenre(Genre.FICTION);
        book2.setAutor(author2);
        books.add(book2);
        Book book3 = new Book();
        book3.setTitle("Лабиринт отражений");
        book3.setGenre(Genre.SF);
        book3.setAutor(author3);
        books.add(book3);
        Book book4 = new Book();
        book4.setTitle("Осенние визиты");
        book4.setGenre(Genre.SF);
        book4.setAutor(author4);
        books.add(book4);


        BookDAO bookDAO = (BookDAO) new BookDAOImpl();
        books.forEach(bookDAO::addBook);



        List<Car>cars=new ArrayList<>();

        Car car1=new Car();
        car1.setModel("Vazik");
        car1.setClassType(ClassType.Dclass);
        car1.setAutor(author1);
        cars.add(car1);
        Car car2=new Car();
        car2.setModel("Jigul");
        car2.setClassType(ClassType.Cclass);
        car2.setAutor(author2);
        cars.add(car2);
        Car car3=new Car();
        car3.setModel("Niva");
        car3.setClassType(ClassType.Bclass);
        car3.setAutor(author3);
        cars.add(car3);
        Car car4=new Car();
        car4.setModel("Lanos");
        car4.setClassType(ClassType.Aclass);
        car4.setAutor(author4);
        cars.add(car4);

        CarDAOImpl carDAO=new CarDAOImpl();
        cars.forEach(carDAO::addCar);


        System.out.println("\n-----------------------------------------------------------\n");

        List<Autor> allAutors = autorDAO.getAllAutors();

        allAutors.forEach(autor -> {
            System.out.println(autor.getAutorName() + " ");
            autor.getBooks().forEach(book ->
                    System.out.println("\t" + book.getTitle() + " : " + book.getGenre().toString()));
            autor.getCars().forEach(car ->
                    System.out.println("\t" + car.getModel() + " : " + car.getClassType().toString()));
        });

        DataBaseCon.closeSession();

    }
}