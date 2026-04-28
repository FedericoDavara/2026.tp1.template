package model;

public class Estudiante extends Socio {

    public Estudiante(int id, String nombre, String email, String dni) {
        super(id, nombre, email, dni);
    }

    @Override
    public int getLimitePrestamos() {
        return 3;
    }
}