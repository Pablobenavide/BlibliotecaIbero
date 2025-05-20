/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ControladorLibro {
    
    public static List<Libro> libros = new ArrayList<>();
    public static int librosPrestados = 0;

    public static void añadir(Libro libro) {
        libros.add(libro);
    }

   /* public static void imprimirLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }*/
public static void editarLibro(int id, String nombre, String autor, String descripcion) {
        for (Libro libro : libros) {
            if (libro.getID() == id) {
                libro.setNombre(nombre);
                libro.setAutor(autor);
                libro.setDescripcion(descripcion);
                break;
            }
        }
    }
public static void eliminarLibro(int id) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getID() == id) {
                iterator.remove();
                break;
            }
        }
    }
public static void prestarLibro(int id) {
    for (Libro libro : libros) {
        if (libro.getID() == id) {
            if (librosPrestados < 1) {
                libro.setEstado(false);
                librosPrestados++;
                JOptionPane.showMessageDialog(null, "El libro ha sido prestado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "El libro no esta disponible");
            }
            break;
        }
    }
}
public static void devolverLibro(int id) {
    for (Libro libro : libros) {
        if (libro.getID() == id) {
            if (librosPrestados > 0) {
                libro.setEstado(true);
                librosPrestados--;
                JOptionPane.showMessageDialog(null, "El libro ha sido devuelto con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "El libro no ha sido prestado");
            }
            break;
        }
    }
}

}
