package controller;

import java.util.ArrayList;
import java.util.Iterator;
import model.Usuario;
import view.Panta1;
import view.Pantalla;
import view.PantallaAdmin;

public class ControladorUsuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public static void verUsuarios() {
        for(Usuario usuario : usuarios) {
            System.out.println(usuario.getNombreUsuario());
        }
    }
    
    public static boolean login(String nombreUsuario, String password) {
    for (Usuario usuario : usuarios) {
        
        if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password)) {
            if (nombreUsuario.equals("admin")) {
                mostrarMenuAdmin();
            } else {
                mostrarMenuUsuarioAutenticado();
            }
            System.out.println("Ingreso exitoso");  
            return true; 
        }
    }
    System.out.println("Ingreso fallido");
    return false; 
}
    
public static void eliminarUsuario(String nombreUsuario) {
        Iterator<Usuario> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                iterator.remove();
                break;
            }
        }
    
}
    
    private static void mostrarMenuAdmin() {
        Pantalla inter = new Pantalla();
        inter.setVisible(false);
        PantallaAdmin ingre = new PantallaAdmin();
        ingre.setVisible(true);
        ingre.setResizable(false);
        ingre.setLocationRelativeTo(null);
        
    }
    
    public static void mostrarMenuUsuarioAutenticado() {
        Pantalla inter = new Pantalla();
        inter.setVisible(false);
        Panta1 pantausu = new Panta1();
        pantausu.setVisible(true);
        pantausu.setResizable(false);
        pantausu.setLocationRelativeTo(null);
    }
}


