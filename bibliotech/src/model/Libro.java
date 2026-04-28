package model;

public record Libro(

        // ISBN único del libro
        String isbn,

        // Título del libro
        String titulo,

        // Autor del libro
        String autor,

        // Año de publicación
        int anio,

        // Categoría del libro (enum)
        Categoria categoria

) implements Recurso {

    public Libro {

        // Validación de ISBN
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("El ISBN no puede estar vacío");
        }

        // Validación de título
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        // Validación de autor
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }

        // Validación de año
        if (anio <= 0) {
            throw new IllegalArgumentException("El año debe ser válido");
        }

        // Validación de categoría
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
    }

    @Override
    public String isbn() {
        return isbn;
    }

    @Override
    public String titulo() {
        return titulo;
    }
}
