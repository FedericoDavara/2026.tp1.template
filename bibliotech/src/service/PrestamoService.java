package service;

import model.Prestamo;

import java.util.List;

public interface PrestamoService {

    void realizarPrestamo(String idPrestamo, String isbn, int socioId);

    // 🆕 devolver libro
    void devolverPrestamo(String idPrestamo);

    // 🆕 préstamos activos
    List<Prestamo> listarActivos();

    // 🆕 historial completo
    List<Prestamo> listarTodos();
}