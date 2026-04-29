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
import exception.PrestamoException;
import repository.impl.PrestamoRepositoryInMemory;
import service.PrestamoService;
import service.impl.PrestamoServiceImpl;

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

        PrestamoService prestamoService = new PrestamoServiceImpl(
                libroRepo,
                socioRepo,
                prestamoRepo
        );

        //  Crear préstamos
        try {
            prestamoService.realizarPrestamo("P1", "1", 1);
            prestamoService.realizarPrestamo("P2", "1", 1);
            prestamoService.realizarPrestamo("P3", "1", 1);

        } catch (PrestamoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //  Mostrar activos
        System.out.println("\nPréstamos activos:");
        prestamoService.listarActivos().forEach(System.out::println);

        // Devolver un libro
        try {
            prestamoService.devolverPrestamo("P1");
        } catch (PrestamoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Activos después de devolución
        System.out.println("\nPréstamos activos después de devolver uno:");
        prestamoService.listarActivos().forEach(System.out::println);

        // Historial completo
        System.out.println("\nHistorial completo:");
        prestamoService.listarTodos().forEach(System.out::println);
    }
}
