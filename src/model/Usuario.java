package model;


import java.util.ArrayList;
import java.util.List;

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
    private List<Libro> librosPrestados;
    private TipoUsuarioEnum tipoUsuario;


    public Usuario(String nombreUsuario, String password, TipoUsuarioEnum tipoUsuario) {    
        this.ID = autoincrementable++;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.librosPrestados = new ArrayList<Libro>();
        this.tipoUsuario = tipoUsuario;

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
        librosPrestados.add(libro);
    }

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

    public void retirarLibroPrestado(int numID) {
        for (Libro libro : librosPrestados) {
            if (libro.getID() == numID) {
                librosPrestados.remove(libro);
                System.out.println("Libro retirado: " + libro);
                return;
            }
        }
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre de USuario:" + nombreUsuario;
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
