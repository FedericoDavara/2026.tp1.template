package repository;

import model.Prestamo;
import java.util.List;

public interface PrestamoRepository extends Repository<Prestamo, String> {

    List<Prestamo> buscarPorSocio(int socioId);

    List<Prestamo> buscarActivos();
}