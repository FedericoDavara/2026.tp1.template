import exception.SocioException;
import model.*;
import repository.impl.LibroRepositoryInMemory;
import repository.impl.SocioRepositoryInMemory;
import service.LibroService;
import service.SocioService;
import service.impl.LibroServiceImpl;
import service.impl.SocioServiceImpl;

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

        try {
            var s1 = new Estudiante(1, "Juan", "juan@mail.com", "123");
            var s2 = new Docente(2, "Ana", "ana@mail.com", "456");

            socioService.registrarSocio(s1);
            socioService.registrarSocio(s2);

            //  Intento duplicado (debe fallar)
            var s3 = new Estudiante(3, "Pedro", "pedro@mail.com", "123");
            socioService.registrarSocio(s3);

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
    }
}