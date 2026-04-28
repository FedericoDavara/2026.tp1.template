package model;

import java.time.LocalDate;

public class Prestamo {

    private String id;
    private Libro libro;
    private Socio socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(String id, Libro libro, Socio socio) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID inválido");
        }
        if (libro == null) {
            throw new IllegalArgumentException("Libro requerido");
        }
        if (socio == null) {
            throw new IllegalArgumentException("Socio requerido");
        }

        this.id = id;
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null; // aún no devuelto
    }

    public String getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Marca el préstamo como devuelto.
     */
    public void devolver() {
        this.fechaDevolucion = LocalDate.now();
    }

    /**
     * Indica si el préstamo sigue activo.
     */
    public boolean estaActivo() {
        return fechaDevolucion == null;
    }

    @Override
    public String toString() {
        return "Prestamo [" +
                "ID=" + id +
                ", Libro=" + libro.titulo() +
                ", Socio=" + socio.getNombre() +
                ", Fecha Prestamo=" + fechaPrestamo +
                ", Devuelto=" + (fechaDevolucion != null ? fechaDevolucion : "No") +
                "]";
    }
}