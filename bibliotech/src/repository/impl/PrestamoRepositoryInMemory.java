package repository.impl;

import model.Prestamo;
import repository.PrestamoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrestamoRepositoryInMemory implements PrestamoRepository {

    private final List<Prestamo> prestamos = new ArrayList<>();

    @Override
    public void guardar(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    @Override
    public Optional<Prestamo> buscarPorId(String id) {
        return prestamos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Prestamo> buscarTodos() {
        return new ArrayList<>(prestamos);
    }

    @Override
    public List<Prestamo> buscarPorSocio(int socioId) {
        return prestamos.stream()
                .filter(p -> p.getSocio().getId() == socioId)
                .toList();
    }

    @Override
    public List<Prestamo> buscarActivos() {
        return prestamos.stream()
                .filter(Prestamo::estaActivo)
                .toList();
    }
}
