package repository.impl;

import model.Socio;
import repository.SocioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SocioRepositoryInMemory implements SocioRepository {

    private final List<Socio> socios = new ArrayList<>();

    @Override
    public void guardar(Socio socio) {
        socios.add(socio);
    }

    @Override
    public Optional<Socio> buscarPorId(Integer id) {
        return socios.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public List<Socio> buscarTodos() {
        return new ArrayList<>(socios);
    }

    @Override
    public Optional<Socio> buscarPorDni(String dni) {
        return socios.stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst();
    }
}