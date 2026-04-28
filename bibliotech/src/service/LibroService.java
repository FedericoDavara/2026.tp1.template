package service;

import model.Libro;
import java.util.List;

/**
 * Capa de lógica de negocio.
 */
public interface LibroService {

    void registrarLibro(Libro libro);

    List<Libro> buscarPorTitulo(String titulo);

    List<Libro> buscarPorAutor(String autor);

    List<Libro> buscarPorCategoria(String categoria);
}