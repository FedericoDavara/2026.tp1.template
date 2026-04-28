package repository;

import model.Socio;
import java.util.Optional;


public interface SocioRepository extends Repository<Socio, Integer> {

    Optional<Socio> buscarPorDni(String dni);
}