/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import controller.ArbolesController;
import model.Usuario;
import view.Pantalla;


/**
 *
 * @author pablo
 */
public class Main {
       
    public static void main(String[] args) {
        // Crear usuario administrador
        Usuario admin = new Usuario("admin", "123456");

        // Obtener instancia del singleton y agregar usuario
        ArbolesController arboles = ArbolesController.getInstancia();
        arboles.insertarUsuario(admin);

        // Mostrar interfaz gráfica
        Pantalla inter = new Pantalla();
        inter.setVisible(true);
        inter.setLocationRelativeTo(null);
        inter.setResizable(false);
    }


    
}
