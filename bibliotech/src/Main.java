import model.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== PRUEBA DE LIBROS ===");

        //  Crear libro físico
        LibroFisico libro1 = new LibroFisico(
                "1",
                "Python para principiantes",
                "Jose Hernandez",
                2022,
                Categoria.PROGRAMACION,
                5
        );

        // Crear ebook
        Ebook libro2 = new Ebook(
                "2",
                "Redes Modernas",
                "Tanenbaum",
                2010,
                Categoria.REDES,
                "PDF"
        );

        //  Mostrar libros
        System.out.println(libro1);
        System.out.println(libro2);

        System.out.println("\n=== PRUEBA DE SOCIOS ===");

        //  Crear socios
        Socio socio1 = new Estudiante(
                1,
                "Juan Pérez",
                "juan@mail.com",
                "12345678"
        );

        Socio socio2 = new Docente(
                2,
                "Ana López",
                "ana@mail.com",
                "87654321"
        );

        //  Mostrar socios
        System.out.println(socio1);
        System.out.println(socio2);

        System.out.println("\n=== Prueba de POLIMORFISMO ===");

        //  Demostración de polimorfismo (clave para la nota)
        Socio[] socios = {socio1, socio2};

        for (Socio s : socios) {
            System.out.println(
                    s.getNombre() + " puede pedir hasta "
                            + s.getLimitePrestamos() + " libros"
            );
        }
    }
}