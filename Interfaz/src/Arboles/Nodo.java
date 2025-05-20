
package Arboles;
import newpackage.*;

public class Nodo {
    
    Usuario usuario;
    Libro libro;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.izquierdo = null;
        this.derecho = null;
    }
    
}
