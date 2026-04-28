import model.*;
import repository.impl.LibroRepositoryInMemory;
import service.LibroService;
import service.impl.LibroServiceImpl;

public class Main {

    public static void main(String[] args) {

        // 🔌 Inyección de dependencias manual
        var repo = new LibroRepositoryInMemory();
        LibroService service = new LibroServiceImpl(repo);

        // 📚 Crear libros
        var libro1 = new LibroFisico("1", "Programación para principiantes", "Jose Hernandez", 2022, Categoria.PROGRAMACION, 5);
        var libro2 = new Ebook("2", "Redes Modernas", "Tanenbaum", 2010, Categoria.REDES, "PDF");

        // 💾 Guardar
        service.registrarLibro(libro1);
        service.registrarLibro(libro2);

        // 🔍 Buscar
        System.out.println("Buscar por título:");
        service.buscarPorTitulo("programación").forEach(System.out::println);

        System.out.println("\nBuscar por categoría:");
        service.buscarPorCategoria("REDES").forEach(System.out::println);
    }
}