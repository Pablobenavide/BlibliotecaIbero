/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import arbolesPackage.*;
import model.Usuario;
import view.Pantalla;


/**
 *
 * @author pablo
 */
public class Main {
       
    public static void main(String[] args) {
        
        Usuario admin = new Usuario("admin","123456");
        Arboles.arbolUsuarios.insertarUsuario(admin);
        //mostrar pantalla
        Pantalla inter = new Pantalla();
        inter.setVisible(true);
        inter.setLocationRelativeTo(null);
        inter.setResizable(false);
        
        
        
    }

    
}
