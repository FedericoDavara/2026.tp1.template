package service.impl;

import model.Libro;
import repository.LibroRepository;
import service.LibroService;

import java.util.List;


public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public void registrarLibro(Libro libro) {
        libroRepository.guardar(libro);
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.buscarPorTitulo(titulo);
    }

    @Override
    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.buscarPorAutor(autor);
    }

    @Override
    public List<Libro> buscarPorCategoria(String categoria) {
        return libroRepository.buscarPorCategoria(categoria);
    }
}
