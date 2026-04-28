package service;

import model.Socio;

import java.util.List;

public interface SocioService {

    void registrarSocio(Socio socio);

    List<Socio> listarSocios();
}