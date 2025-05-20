package newpackage;

/**
 @Pablo David Benavides Tunjano
 @Ricardo Alfonso Tafur Caaballo
 @Samuel Gaviria Morales
 */

public class Libro {
    
    private static int autoincrementable = 1;
    private int ID;
    private String nombre;
    private String autor;
    private String descripcion, estadoPrestar;
    private boolean estado;
    

    public Libro(String nombre, String autor, String descripcion) {
        this.ID = autoincrementable++;
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
        this.estado = true;
        this.estadoPrestar = "";
    }

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
    
    public void prestar() {
        this.estado = false;
    }
    
    public void devolver(){
        this.estado = true;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        if (estado == true){
            estadoPrestar = "disponible";
        }else{
        estadoPrestar = "prestado";
        }
        return "ID: " + ID + ", nombre: " + nombre + ", autor: " + autor + ", descripcion: " + descripcion + ", estado: " + estadoPrestar;
    }

}