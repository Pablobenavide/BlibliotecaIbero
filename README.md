# 📚 Sistema de Gestión de Biblioteca en Java

Este proyecto es una aplicación de escritorio desarrollada en Java que permite gestionar una biblioteca con usuarios y libros. Utiliza estructuras de datos como árboles binarios de búsqueda (ABB) para almacenar libros y usuarios, y emplea un patrón de diseño Singleton para el controlador principal del sistema.

## 🚀 Funcionalidades

- **Gestión de Libros**
  - Agregar libros
  - Editar información de libros
  - Buscar libros por ID
  - Eliminar libros
  - Prestar y devolver libros

- **Gestión de Usuarios**
  - Registro de nuevos usuarios
  - Login de usuarios y administradores
  - Eliminación de usuarios
  - Asociación de libros prestados a usuarios

- **Roles de Usuario**
  - 📘 Usuario regular: puede buscar libros, prestar y devolver libros.
  - 🔐 Administrador: puede gestionar el catálogo completo y los usuarios.

## 🛠️ Tecnologías y Arquitectura

- Java (JDK 17+)
- Swing para la interfaz gráfica (GUI)
- Estructuras de datos (árboles binarios)
- Patrón Singleton para el controlador (`ArbolesController`)
- POO (Programación Orientada a Objetos)

## 🧩 Estructura del Proyecto
src/

│

├── modelo/

│ ├── Libro.java

│ ├── Usuario.java

│ └── Arbol.java

│

├── controlador/

│ └── ArbolesController.java

│

├── vistas/

│ ├── Pantalla.java

│ ├── PantallaAdmin.java

│ └── Panta1.java

│

└── Main.java


## 🧪 Cómo Ejecutar

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/biblioteca-java.git
   cd biblioteca-java

2. Abre el proyecto en tu IDE de preferencia (NetBeans, IntelliJ IDEA, Eclipse...).

3. Compila y ejecuta el archivo Main.java.

4. Al iniciar, se crea automáticamente un usuario administrador:
Usuario: admin
Contraseña: 123456

## Notas Técnicas

- El controlador ArbolesController es un singleton que contiene:

  - Un árbol de libros (Arbol libros)

  - Un árbol de usuarios (Arbol arbolUsuarios)

  - El usuario autenticado actualmente (usuarioActual)

- Los árboles implementan operaciones básicas:

  - Insertar, buscar, eliminar, imprimir.

- Cada usuario tiene su propio árbol de libros prestados (gestionado por el controlador).

## 🎯 Futuras Mejoras

Persistencia en archivos o base de datos.

Validación más robusta de entrada del usuario.

Historial de préstamos.

Interfaz más moderna usando JavaFX o frameworks externos.

## 🧑‍💻 Autor

Desarrollado por:

- Pablo David Benavides Tunjano

- Samuel Gaviria Morales

