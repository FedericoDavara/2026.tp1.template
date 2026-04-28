package repository.impl;

import model.Libro;
import repository.LibroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación en memoria del repositorio de libros.
 */
public class LibroRepositoryInMemory implements LibroRepository {

    private final List<Libro> libros = new ArrayList<>();

    @Override
    public void guardar(Libro libro) {
        libros.add(libro);
    }

    @Override
    public Optional<Libro> buscarPorId(String isbn) {
        return libros.stream()
                .filter(l -> l.isbn().equals(isbn))
                .findFirst();
    }

    @Override
    public List<Libro> buscarTodos() {
        return new ArrayList<>(libros);
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return libros.stream()
                .filter(l -> l.titulo().toLowerCase().contains(titulo.toLowerCase()))
                .toList();
    }

    @Override
    public List<Libro> buscarPorAutor(String autor) {
        return libros.stream()
                .filter(l -> l.autor().toLowerCase().contains(autor.toLowerCase()))
                .toList();
    }

    @Override
    public List<Libro> buscarPorCategoria(String categoria) {
        return libros.stream()
                .filter(l -> l.categoria().name().equalsIgnoreCase(categoria))
                .toList();
    }
}