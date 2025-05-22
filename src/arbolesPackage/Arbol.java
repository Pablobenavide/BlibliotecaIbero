package arbolesPackage;

import model.Libro;
import model.Usuario;


public class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertarUsuario(Usuario usuario) {
        raiz = insertarUsuarioRec(raiz, usuario);
    }

    public void insertarLibro(Libro libro) {
        raiz = insertarLibroRec(raiz, libro);
    }

    private Nodo insertarUsuarioRec(Nodo nodo, Usuario usuario) {
        if (nodo == null) {
            nodo = new Nodo(usuario, null);
            return nodo;
        }

        if (usuario.getID() < nodo.usuario.getID()) {
            nodo.izquierdo = insertarUsuarioRec(nodo.izquierdo, usuario);
        } else if (usuario.getID() > nodo.usuario.getID()) {
            nodo.derecho = insertarUsuarioRec(nodo.derecho, usuario);
        }

        return nodo;
    }

    private Nodo insertarLibroRec(Nodo nodo, Libro libro) {
        if (nodo == null) {
            nodo = new Nodo(null, libro);
            return nodo;
        }

        if (libro.getID() < nodo.libro.getID()) {
            nodo.izquierdo = insertarLibroRec(nodo.izquierdo, libro);
        } else if (libro.getID() > nodo.libro.getID()) {
            nodo.derecho = insertarLibroRec(nodo.derecho, libro);
        }

        return nodo;
    }

    public  Usuario buscarUsuarioPorID(int id) {
        return buscarUsuarioPorIDRec(raiz, id);
    }

    public Libro buscarLibroPorID(int id) {
        return buscarLibroPorIDRec(raiz, id);
    }
    
    public Libro buscarLibroPorNombre(String nombre) {
        return buscarLibroPorNombreRec(raiz, nombre);
    }

    private Usuario buscarUsuarioPorIDRec(Nodo nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (nodo.usuario != null && nodo.usuario.getID() == id) {
            return nodo.usuario;
        }

        Usuario usuarioEncontrado = buscarUsuarioPorIDRec(nodo.izquierdo, id);
        if (usuarioEncontrado != null) {
            return usuarioEncontrado;
        }

        return buscarUsuarioPorIDRec(nodo.derecho, id);
    }

    private Libro buscarLibroPorIDRec(Nodo nodo, int id) {
        if (nodo == null) {
            return null;
        }
        

        if (nodo.libro != null && nodo.libro.getID() == id) {
            return nodo.libro;
        }

        Libro libroEncontrado = buscarLibroPorIDRec(nodo.izquierdo, id);
        if (libroEncontrado != null) {
            return libroEncontrado;
        }

        return buscarLibroPorIDRec(nodo.derecho, id);
    }
    
    private Libro buscarLibroPorNombreRec(Nodo nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        

        if (nodo.libro != null && (nodo.libro.getNombre() == null ? nombre == null : nodo.libro.getNombre().equals(nombre))) {
            return nodo.libro;
        }

        Libro libroEncontrado = buscarLibroPorNombreRec(nodo.izquierdo, nombre);
        if (libroEncontrado != null) {
            return libroEncontrado;
        }

        return buscarLibroPorNombreRec(nodo.derecho, nombre);
    }


    public boolean cambiarEstadoLibroPorID(int id) {
        return cambiarEstadoLibroPorIDRec(raiz, id);
    }

    public Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        return buscarUsuarioPorNombreRec(raiz, nombreUsuario);
    }

    private Usuario buscarUsuarioPorNombreRec(Nodo nodo, String nombreUsuario) {
        if (nodo == null) {
            return null;
        }

        if (nodo.usuario != null && nodo.usuario.getNombreUsuario().equals(nombreUsuario)) {
            return nodo.usuario;
        }

        Usuario usuarioEncontrado = buscarUsuarioPorNombreRec(nodo.izquierdo, nombreUsuario);
        if (usuarioEncontrado != null) {
            return usuarioEncontrado;
        }

        return buscarUsuarioPorNombreRec(nodo.derecho, nombreUsuario);
    }

    private boolean cambiarEstadoLibroPorIDRec(Nodo nodo, int id) {
        if (nodo == null) {
            return false;
        }

        if (nodo.libro != null && nodo.libro.getID() == id) {
            nodo.libro.setEstado(!nodo.libro.getEstado());
            return true;
        }

        if (cambiarEstadoLibroPorIDRec(nodo.izquierdo, id)) {
            return true;
        }

        return cambiarEstadoLibroPorIDRec(nodo.derecho, id);
    }

    public void imprimirInformacionLibro() {
        imprimirInformacionLibroRec(raiz);
    }

    private void imprimirInformacionLibroRec(Nodo nodo) {
        if (nodo != null) {
            imprimirInformacionLibroRec(nodo.izquierdo);
            if (nodo.libro != null) {
                System.out.println(nodo.libro.toString());

            }
            imprimirInformacionLibroRec(nodo.derecho);
        }
    }
    
    public void imprimirInformacionUsuario() {
        imprimirInformacionUsuarioRec(raiz);
    }

    private void imprimirInformacionUsuarioRec(Nodo nodo) {
        if (nodo != null) {
            imprimirInformacionUsuarioRec(nodo.izquierdo);
            if (nodo.usuario != null) {
                System.out.println(nodo.usuario.toString());

            }
            imprimirInformacionUsuarioRec(nodo.derecho);
        }
    }

    public void eliminarLibro(int id) {
        raiz = eliminarLibroRec(raiz, id);
    }

    private Nodo eliminarLibroRec(Nodo nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id < nodo.libro.getID()) {
            nodo.izquierdo = eliminarLibroRec(nodo.izquierdo, id);
        } else if (id > nodo.libro.getID()) {
            nodo.derecho = eliminarLibroRec(nodo.derecho, id);
        } else {

            // Caso 1: El nodo a eliminar no tiene hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            // Caso 2: El nodo a eliminar tiene un hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // Caso 3: El nodo a eliminar tiene dos hijos
            Nodo sucesor = encontrarSucesor(nodo.derecho);
            nodo.libro = sucesor.libro;
            nodo.derecho = eliminarLibroRec(nodo.derecho, sucesor.libro.getID());

        }
        return nodo;
    }

    private Nodo encontrarSucesor(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public void eliminarUsuario(int id) {
        raiz = eliminarUsuarioRec(raiz, id);
    }

    private Nodo eliminarUsuarioRec(Nodo nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id < nodo.usuario.getID()) {
            nodo.izquierdo = eliminarUsuarioRec(nodo.izquierdo, id);
        } else if (id > nodo.usuario.getID()) {
            nodo.derecho = eliminarUsuarioRec(nodo.derecho, id);
        } else {
            // Caso 1: El nodo a eliminar no tiene hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            // Caso 2: El nodo a eliminar tiene un hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // Caso 3: El nodo a eliminar tiene dos hijos
            Nodo sucesor = encontrarSucesor(nodo.derecho);
            nodo.usuario = sucesor.usuario;
            nodo.derecho = eliminarLibroRec(nodo.derecho, sucesor.usuario.getID());
        }
        return nodo;
    }


}
