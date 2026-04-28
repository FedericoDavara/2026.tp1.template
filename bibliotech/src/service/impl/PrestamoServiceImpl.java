package service.impl;

import exception.LibroNoDisponibleException;
import exception.LimitePrestamosException;
import model.Libro;
import model.Prestamo;
import model.Socio;
import repository.LibroRepository;
import repository.PrestamoRepository;
import repository.SocioRepository;
import service.PrestamoService;

public class PrestamoServiceImpl implements PrestamoService {

    private final LibroRepository libroRepo;
    private final SocioRepository socioRepo;
    private final PrestamoRepository prestamoRepo;

    public PrestamoServiceImpl(
            LibroRepository libroRepo,
            SocioRepository socioRepo,
            PrestamoRepository prestamoRepo) {

        this.libroRepo = libroRepo;
        this.socioRepo = socioRepo;
        this.prestamoRepo = prestamoRepo;
    }

    @Override
    public void realizarPrestamo(String idPrestamo, String isbn, int socioId) {

        // 🔍 Buscar libro
        Libro libro = libroRepo.buscarPorId(isbn)
                .orElseThrow(() -> new LibroNoDisponibleException("Libro no encontrado"));

        // 🔍 Buscar socio
        Socio socio = socioRepo.buscarPorId(socioId)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        // 🔴 VALIDACIÓN 1: disponibilidad (libro físico)
        if (libro instanceof model.LibroFisico fisico) {

            long prestamosActivos = prestamoRepo.buscarActivos().stream()
                    .filter(p -> p.getLibro().equals(libro))
                    .count();

            if (prestamosActivos >= fisico.getCantidadEjemplares()) {
                throw new LibroNoDisponibleException("No hay ejemplares disponibles");
            }
        }

        // 🔴 VALIDACIÓN 2: límite de préstamos del socio
        long prestamosSocio = prestamoRepo.buscarActivos().stream()
                .filter(p -> p.getSocio().getId() == socioId)
                .count();

        if (prestamosSocio >= socio.getLimitePrestamos()) {
            throw new LimitePrestamosException("El socio alcanzó su límite de préstamos");
        }

        // ✅ Crear préstamo
        Prestamo prestamo = new Prestamo(idPrestamo, libro, socio);

        prestamoRepo.guardar(prestamo);
    }
}