package controller;

import model.Usuario;
import model.Libro;

import java.util.Map;
import java.util.TreeMap;

public class ArbolesController {
    private static ArbolesController instancia;

    private Usuario usuarioActual;
    private final TreeMap<Integer, Usuario> arbolUsuarios = new TreeMap<>();
    private final TreeMap<Integer, Libro> arbolLibros = new TreeMap<>();
    private final Map<String, Usuario> usuariosPorNombre = new TreeMap<>();
    private final Map<String, Libro> librosPorNombre = new TreeMap<>();

    private ArbolesController() {
        // Constructor privado para evitar instancias externas
    }

    public static ArbolesController getInstancia() {
        if (instancia == null) {
            instancia = new ArbolesController();
        }
        return instancia;
    }

    // Métodos públicos

    public void insertarUsuario(Usuario usuario) {
        arbolUsuarios.put(usuario.getID(), usuario);
        usuariosPorNombre.put(usuario.getNombreUsuario(), usuario);
    }

    public Usuario buscarUsuarioPorID(int id) {
        return arbolUsuarios.get(id);
    }

    public Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        return usuariosPorNombre.get(nombreUsuario);
    }

    public void eliminarUsuario(int id) {
        Usuario eliminado = arbolUsuarios.remove(id);
        if (eliminado != null) {
            usuariosPorNombre.remove(eliminado.getNombreUsuario());
        }
    }

    public void imprimirUsuarios() {
        for (Usuario usuario : arbolUsuarios.values()) {
            System.out.println(usuario);
        }
    }

    public void insertarLibro(Libro libro) {
        arbolLibros.put(libro.getID(), libro);
        librosPorNombre.put(libro.getNombre(), libro);
    }

    public Libro buscarLibroPorID(int id) {
        return arbolLibros.get(id);
    }

    public Libro buscarLibroPorNombre(String nombre) {
        return librosPorNombre.get(nombre);
    }

    public boolean cambiarEstadoLibroPorID(int id) {
        Libro libro = arbolLibros.get(id);
        if (libro != null) {
            libro.setEstado(!libro.getEstado());
            return true;
        }
        return false;
    }

    public void eliminarLibro(int id) {
        Libro eliminado = arbolLibros.remove(id);
        if (eliminado != null) {
            librosPorNombre.remove(eliminado.getNombre());
        }
    }

    public void imprimirLibros() {
        for (Libro libro : arbolLibros.values()) {
            System.out.println(libro);
        }
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
