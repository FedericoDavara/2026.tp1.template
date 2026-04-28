package service.impl;

import exception.SocioException;
import model.Socio;
import repository.SocioRepository;
import service.SocioService;

import java.util.List;

public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;

    public SocioServiceImpl(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @Override
    public void registrarSocio(Socio socio) {

        // 🔥 Validación de DNI único
        socioRepository.buscarPorDni(socio.getDni())
                .ifPresent(s -> {
                    throw new SocioException("El DNI ya está registrado");
                });

        socioRepository.guardar(socio);
    }

    @Override
    public List<Socio> listarSocios() {
        return socioRepository.buscarTodos();
    }
}