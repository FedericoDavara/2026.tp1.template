import exception.SocioException;
import model.*;
import repository.impl.LibroRepositoryInMemory;
import repository.impl.SocioRepositoryInMemory;
import service.LibroService;
import service.SocioService;
import service.impl.LibroServiceImpl;
import service.impl.SocioServiceImpl;
import repository.impl.PrestamoRepositoryInMemory;
import model.Prestamo;

public class Main {

    public static void main(String[] args) {

        // ================= LIBROS =================
        System.out.println("=========== LIBROS ===========");

        var libroRepo = new LibroRepositoryInMemory();
        LibroService libroService = new LibroServiceImpl(libroRepo);

        var libro1 = new LibroFisico("1", "Python para principiantes", "Jose Hernandez", 2022, Categoria.PROGRAMACION, 5);
        var libro2 = new Ebook("2", "Redes Modernas", "Tanenbaum", 2010, Categoria.REDES, "PDF");

        libroService.registrarLibro(libro1);
        libroService.registrarLibro(libro2);

        libroService.buscarTodos().forEach(System.out::println);

        // ================= SOCIOS =================
        System.out.println("\n=========== SOCIOS ===========");

        var socioRepo = new SocioRepositoryInMemory();
        SocioService socioService = new SocioServiceImpl(socioRepo);

        Socio socio1 = new Estudiante(1, "Juan", "juan@mail.com", "123");
        Socio socio2 = new Docente(2, "Ana", "ana@mail.com", "456");

        try {
            socioService.registrarSocio(socio1);
            socioService.registrarSocio(socio2);

        } catch (SocioException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Mostrar socios válidos
        System.out.println("\nSocios registrados:");
        socioService.listarSocios().forEach(System.out::println);

        // ================= POLIMORFISMO =================
        System.out.println("\n=========== Prueba de POLIMORFISMO ===========");

        for (Socio s : socioService.listarSocios()) {
            System.out.println(
                    s.getNombre() + " puede pedir hasta "
                            + s.getLimitePrestamos() + " libros"
            );
        }
        System.out.println("\n=========== PRÉSTAMOS ===========");

        var prestamoRepo = new PrestamoRepositoryInMemory();

        // usamos datos que ya tenías
        var prestamo1 = new Prestamo("P1", libro1, socio1);

        prestamoRepo.guardar(prestamo1);

        // mostrar todos
        prestamoRepo.buscarTodos().forEach(System.out::println);

        // mostrar activos
        System.out.println("\nPréstamos activos:");
        prestamoRepo.buscarActivos().forEach(System.out::println);
    }
}
