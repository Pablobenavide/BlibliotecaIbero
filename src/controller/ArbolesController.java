package controller;

import model.Usuario;
import model.Libro;

import java.util.Map;
import java.util.TreeMap;

public class ArbolesController {

    // Instancia única para implementar el patrón Singleton
    private static ArbolesController instancia;

    // Usuario actualmente en sesión
    private Usuario usuarioActual;

    // Estructuras para almacenar usuarios y libros ordenadamente por ID
    private final TreeMap<Integer, Usuario> arbolUsuarios = new TreeMap<>();
    private final TreeMap<Integer, Libro> arbolLibros = new TreeMap<>();

    // Estructuras para buscar usuarios y libros por su nombre
    private final Map<String, Usuario> usuariosPorNombre = new TreeMap<>();
    private final Map<String, Libro> librosPorNombre = new TreeMap<>();

    // Constructor privado para evitar la creación de múltiples instancias
    private ArbolesController() {}

    // Método para obtener la instancia única de la clase (Singleton)
    public static ArbolesController getInstancia() {
        if (instancia == null) {
            instancia = new ArbolesController();
        }
        return instancia;
    }

    // Inserta un usuario en los árboles por ID y por nombre
    public void insertarUsuario(Usuario usuario) {
        arbolUsuarios.put(usuario.getID(), usuario);
        usuariosPorNombre.put(usuario.getNombreUsuario(), usuario);
    }

    // Busca un usuario por su ID
    public Usuario buscarUsuarioPorID(int id) {
        return arbolUsuarios.get(id);
    }

    // Busca un usuario por su nombre de usuario
    public Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        return usuariosPorNombre.get(nombreUsuario);
    }

    // Elimina un usuario por su ID de ambas estructuras (por ID y por nombre)
    public void eliminarUsuario(int id) {
        Usuario eliminado = arbolUsuarios.remove(id);
        if (eliminado != null) {
            usuariosPorNombre.remove(eliminado.getNombreUsuario());
        }
    }

    // Imprime todos los usuarios almacenados en el TreeMap
    public void imprimirUsuarios() {
        for (Usuario usuario : arbolUsuarios.values()) {
            System.out.println(usuario);
        }
    }

    // Inserta un libro en los árboles por ID y por nombre
    public void insertarLibro(Libro libro) {
        arbolLibros.put(libro.getID(), libro);
        librosPorNombre.put(libro.getNombre(), libro);
    }

    // Busca un libro por su ID
    public Libro buscarLibroPorID(int id) {
        return arbolLibros.get(id);
    }

    // Busca un libro por su nombre
    public Libro buscarLibroPorNombre(String nombre) {
        return librosPorNombre.get(nombre);
    }

    // Cambia el estado del libro (por ejemplo, disponible/no disponible) según su ID
    public boolean cambiarEstadoLibroPorID(int id) {
        Libro libro = arbolLibros.get(id);
        if (libro != null) {
            libro.setEstado(!libro.getEstado()); // Invierte el estado actual
            return true;
        }
        return false;
    }

    // Elimina un libro por su ID de ambas estructuras (por ID y por nombre)
    public void eliminarLibro(int id) {
        Libro eliminado = arbolLibros.remove(id);
        if (eliminado != null) {
            librosPorNombre.remove(eliminado.getNombre());
        }
    }

    // Imprime todos los libros almacenados en el TreeMap
    public void imprimirLibros() {
        for (Libro libro : arbolLibros.values()) {
            System.out.println(libro);
        }
    }

    // Getter para obtener el usuario que actualmente está usando el sistema
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    // Setter para definir el usuario actualmente en sesión
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    // Elimina un libro del mapa de libros por nombre
    public void eliminarLibroDelMapaPorNombre(String nombre) {
        librosPorNombre.remove(nombre);
    }

    // Inserta un libro en el mapa de libros por nombre
    public void insertarLibroEnMapaPorNombre(Libro libro) {
        librosPorNombre.put(libro.getNombre(), libro);
    }
}
