package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Pablo David Benavides Tunjano
 * @Samuel Gaviria Morales
 */

// Clase que representa a un usuario del sistema
public class Usuario {

    // Atributos estáticos y de instancia
    private static int autoincrementable = 1; // Generador automático de ID
    private int ID; // ID único del usuario
    private String nombreUsuario; // Nombre de usuario (identificación)
    private String password; // Contraseña del usuario
    private List<Libro> librosPrestados; // Lista de libros que el usuario ha prestado
    private TipoUsuarioEnum tipoUsuario; // Tipo de usuario: ADMINISTRADOR o USUARIO

    // Constructor que inicializa un nuevo usuario con nombre, contraseña y tipo
    public Usuario(String nombreUsuario, String password, TipoUsuarioEnum tipoUsuario) {
        this.ID = autoincrementable++; // Asigna un ID único
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.librosPrestados = new ArrayList<Libro>(); // Inicializa la lista de libros
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y setters para los atributos

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método para añadir un libro a la lista de libros prestados
    public void añadirLibroPrestado(Libro libro) {
        librosPrestados.add(libro);
    }

    // Muestra por consola los libros que el usuario ha prestado
    public void verLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No hay libros prestados.");
        } else {
            System.out.println("Libros prestados:");
            for (Libro libro : librosPrestados) {
                System.out.println(libro);
            }
        }
    }

    // Elimina un libro de la lista de libros prestados, usando su ID
    public void retirarLibroPrestado(int numID) {
        for (Libro libro : librosPrestados) {
            if (libro.getID() == numID) {
                librosPrestados.remove(libro); // Elimina el libro de la lista
                System.out.println("Libro retirado: " + libro);
                return;
            }
        }
    }

    // Getter y setter para el tipo de usuario
    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Representación en texto del usuario
    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre de Usuario: " + nombreUsuario;
    }

    // Método no implementado; podría usarse en una clase futura que herede de esta
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Método generado automáticamente, aún sin funcionalidad
    }
}

