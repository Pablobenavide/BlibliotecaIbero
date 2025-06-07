/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import controller.ArbolesController;
import model.Usuario;
import view.Pantalla;
import model.TipoUsuarioEnum;

/**
 * Clase principal que arranca la aplicación.
 * 
 * @author pablo
 */
public class Main {

    public static void main(String[] args) {
        // Crear un usuario de tipo ADMINISTRADOR con nombre "admin" y contraseña "123456"
        Usuario admin = new Usuario("admin", "123456", TipoUsuarioEnum.ADMINISTRADOR);

        // Obtener la instancia única (singleton) del controlador ArbolesController
        ArbolesController arboles = ArbolesController.getInstancia();

        // Insertar el usuario administrador en el sistema (posiblemente en una estructura como un árbol)
        arboles.insertarUsuario(admin);

        // Crear y mostrar la interfaz gráfica principal
        Pantalla inter = new Pantalla();
        inter.setVisible(true); // Hace visible la ventana
        inter.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        inter.setResizable(false); // Evita que el usuario pueda redimensionar la ventana
    }
}

    
}
