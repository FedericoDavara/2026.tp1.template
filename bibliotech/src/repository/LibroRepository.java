package repository;

import model.Libro;
import java.util.List;


public interface LibroRepository extends Repository<Libro, String> {

    List<Libro> buscarPorTitulo(String titulo);

    List<Libro> buscarPorAutor(String autor);

    List<Libro> buscarPorCategoria(String categoria);
}
