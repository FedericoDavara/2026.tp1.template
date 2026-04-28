package model;

public class Docente extends Socio {

    public Docente(int id, String nombre, String email, String dni) {
        super(id, nombre, email, dni);
    }

    @Override
    public int getLimitePrestamos() {
        return 5;
    }
}