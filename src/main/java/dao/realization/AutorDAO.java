package dao.realization;

import domain.Autor;

import java.util.List;

public interface AutorDAO {

    void saveAuthor(Autor autor);

    List<Autor> getAllAutors();
}
