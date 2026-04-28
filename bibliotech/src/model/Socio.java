package model;

public abstract class Socio {

    protected int id;
    protected String nombre;
    protected String email;
    protected String dni;

    public Socio(int id, String nombre, String email, String dni) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("DNI inválido");
        }

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public abstract int getLimitePrestamos();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Email: " + email +
                ", DNI: " + dni;
    }
}