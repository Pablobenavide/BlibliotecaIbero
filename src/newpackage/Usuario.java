package newpackage;


import Arboles.*;

import Arboles.Arbol;

/**
 * @Pablo David Benavides Tunjano
 * @Ricardo Alfonso Tafur Caaballo
 * @Samuel Gaviria Morales
 */

public class Usuario {

    private static int autoincrementable = 1;
    private int ID;
    private String nombreUsuario;
    private String password;
    private Arbol librosPrestados;

    public Usuario(String nombreUsuario, String password) {
        this.ID = autoincrementable++;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.librosPrestados = new Arbol();
    }

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

    public void añadirLibroPrestado(Libro libro) {
        librosPrestados.insertarLibro(libro);
    }

    public void verLibrosPrestados() {
        librosPrestados.imprimirInformacionLibro();

    }

    public void retirarLibroPrestado(int numID) {
        librosPrestados.eliminarLibro(numID);
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre de USuario:" + nombreUsuario;
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
