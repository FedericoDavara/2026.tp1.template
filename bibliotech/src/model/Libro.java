package model;

public abstract class Libro implements Recurso {

    protected String isbn;
    protected String titulo;
    protected String autor;
    protected int anio;
    protected Categoria categoria;

    public Libro(String isbn, String titulo, String autor, int anio, Categoria categoria) {

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("El ISBN no puede estar vacío");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        if (anio <= 0) {
            throw new IllegalArgumentException("El año debe ser válido");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
    }

    @Override
    public String isbn() {
        return isbn;
    }

    @Override
    public String titulo() {
        return titulo;
    }

    public String autor() {
        return autor;
    }

    public int anio() {
        return anio;
    }

    public Categoria categoria() {
        return categoria;
    }
}