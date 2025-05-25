package org.sistemanomina;

public class Persona {
    protected String nombre;
    protected String cedula;
    protected int edad;

    public Persona(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
