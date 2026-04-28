package model;

public class LibroFisico extends Libro {

    private int cantidadEjemplares;

    public LibroFisico(String isbn, String titulo, String autor, int anio, Categoria categoria, int cantidadEjemplares) {
        super(isbn, titulo, autor, anio, categoria);

        if (cantidadEjemplares < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        this.cantidadEjemplares = cantidadEjemplares;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }
}