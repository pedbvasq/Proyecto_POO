package proyecto_poo;

import Archivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    protected String nombre;
    protected String apellido;
    protected String idUsuario;
    protected String contraseña;
    protected char tipo;
    private Scanner sc = new Scanner(System.in);
    private ManejoArchivos file = null;

    public Usuario(String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
     public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Usuario validarUsuario(String usuario , String contraseña) {
        ArrayList<String> usu = file.LeeFichero("usuarios.txt");

        for (Usuario i : listaUsuarios(usu)) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                return i;

            }

        }
        return null;

    }

    public  ArrayList<Usuario> listaUsuarios(ArrayList<String> a) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (String i : a) {
            String[] usu = i.split(";");
            String nombre = usu[0];
            String apellido = usu[1];

            String usuario = usu[2];
            String contraseña = usu[3];
            char tipo = usu[4].charAt(0);
            Usuario user = new Usuario(nombre, apellido, usuario, contraseña, tipo);
            usuarios.add(user);

        }

        return usuarios;

    }

   

}
