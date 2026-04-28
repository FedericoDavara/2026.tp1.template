import model.Categoria;
import model.Libro;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro(
                "123456",
                "Python para principiantes",
                "Jose Hernandez",
                2023,
                Categoria.PROGRAMACION
        );

        System.out.println(libro);
    }
}