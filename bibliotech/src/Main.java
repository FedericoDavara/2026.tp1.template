import model.*;
import repository.impl.LibroRepositoryInMemory;
import repository.impl.SocioRepositoryInMemory;
import service.LibroService;
import service.impl.LibroServiceImpl;

public class Main {

    public static void main(String[] args) {

        System.out.println("=========== LIBROS ===========");

        // 🔌 Inyección de dependencias (libros)
        var libroRepo = new LibroRepositoryInMemory();
        LibroService libroService = new LibroServiceImpl(libroRepo);

        // 📚 Crear libros
        var libro1 = new LibroFisico("1", "Python para principiantes", "Jose hernandez", 2022, Categoria.PROGRAMACION, 5);
        var libro2 = new Ebook("2", "Redes Modernas", "Tanenbaum", 2010, Categoria.REDES, "PDF");

        // 💾 Guardar libros
        libroService.registrarLibro(libro1);
        libroService.registrarLibro(libro2);

        // 🔍 Buscar libros
        System.out.println("\nBuscar por título:");
        libroService.buscarPorTitulo("Python").forEach(System.out::println);

        System.out.println("\nBuscar por categoría:");
        libroService.buscarPorCategoria("REDES").forEach(System.out::println);

        // ==========================================

        System.out.println("\n=========== SOCIOS ===========");

        // 📦 Repository de socios (sin service todavía)
        var socioRepo = new SocioRepositoryInMemory();

        // 👤 Crear socios
        Socio socio1 = new Estudiante(1, "Juan Pérez", "juan@mail.com", "12345678");
        Socio socio2 = new Docente(2, "Ana López", "ana@mail.com", "87654321");

        // 💾 Guardar socios
        socioRepo.guardar(socio1);
        socioRepo.guardar(socio2);

        // 🖨️ Mostrar todos
        System.out.println("\nListado de socios:");
        socioRepo.buscarTodos().forEach(System.out::println);

        // 🔍 Buscar por DNI
        System.out.println("\nBuscar socio por DNI (12345678):");
        socioRepo.buscarPorDni("12345678")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Socio no encontrado")
                );

        // ==========================================

        System.out.println("\n=========== POLIMORFISMO ===========");

        // 🔥 Demostración importante para la nota
        for (Socio s : socioRepo.buscarTodos()) {
            System.out.println(
                    s.getNombre() + " puede pedir hasta "
                            + s.getLimitePrestamos() + " libros"
            );
        }
    }
}