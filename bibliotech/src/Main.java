import model.Categoria;
import model.Ebook;
import model.LibroFisico;

public class Main {

    public static void main(String[] args) {

        // 📚 Crear un libro físico
        LibroFisico libroFisico = new LibroFisico(
                "123456",
                "Programación para principiantes",
                "Jose Hernandez",
                2022,
                Categoria.PROGRAMACION,
                5 // cantidad de ejemplares
        );

        // 📱 Crear un ebook
        Ebook ebook = new Ebook(
                "7891011",
                "Design Patterns",
                "GoF",
                1994,
                Categoria.PROGRAMACION,
                "PDF"
        );

        // 🖨️ Mostrar datos
        System.out.println("=== LIBRO FÍSICO ===");
        System.out.println("ISBN: " + libroFisico.isbn());
        System.out.println("Título: " + libroFisico.titulo());
        System.out.println("Autor: " + libroFisico.autor());
        System.out.println("Ejemplares: " + libroFisico.getCantidadEjemplares());

        System.out.println("\n=== EBOOK ===");
        System.out.println("ISBN: " + ebook.isbn());
        System.out.println("Título: " + ebook.titulo());
        System.out.println("Autor: " + ebook.autor());
        System.out.println("Formato: " + ebook.getFormato());
    }
}