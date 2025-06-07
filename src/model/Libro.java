package model;

/**
 @Pablo David Benavides Tunjano
 @Samuel Gaviria Morales
 */

// Clase que representa un libro dentro del sistema
public class Libro {

    // Variable estática para autoincrementar el ID de cada libro
    private static int autoincrementable = 1;

    // Atributos del libro
    private int ID; // ID único del libro
    private String nombre; // Nombre o título del libro
    private String autor; // Autor del libro
    private String descripcion, estadoPrestar; // Descripción y estado legible del libro
    private boolean estado; // Estado lógico del libro (true = disponible, false = prestado)

    // Constructor que inicializa los atributos y asigna un ID único
    public Libro(String nombre, String autor, String descripcion) {
        this.ID = autoincrementable++; // Asigna y aumenta el ID para el siguiente libro
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
        this.estado = true; // Por defecto, el libro está disponible
        this.estadoPrestar = "";
    }

    // Métodos getter y setter para los atributos del libro

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    // Marca el libro como prestado (estado = false)
    public void prestar() {
        this.estado = false;
    }

    // Marca el libro como devuelto (estado = true)
    public void devolver(){
        this.estado = true;
    }

    // Devuelve el ID del libro
    public int getID() {
        return ID;
    }

    // Devuelve una representación en texto del libro
    @Override
    public String toString() {
        // Dependiendo del estado lógico, asigna una descripción legible
        if (estado == true){
            estadoPrestar = "disponible";
        } else {
            estadoPrestar = "prestado";
        }
        // Retorna una cadena con todos los datos del libro
        return "ID: " + ID + ", nombre: " + nombre + ", autor: " + autor +
               ", descripcion: " + descripcion + ", estado: " + estadoPrestar;
    }

}

