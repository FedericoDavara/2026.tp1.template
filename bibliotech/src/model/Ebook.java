package model;


public class Ebook extends Libro {

    private String formato; // PDF, EPUB, etc.

    public Ebook(String isbn, String titulo, String autor, int anio, Categoria categoria, String formato) {
        super(isbn, titulo, autor, anio, categoria);

        if (formato == null || formato.isBlank()) {
            throw new IllegalArgumentException("El formato no puede estar vacío");
        }

        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }
}