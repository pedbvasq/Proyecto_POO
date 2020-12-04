package Usuarios;

import Archivos.ManejoArchivos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Usuario {

    protected String nombre;
    protected String apellido;
    protected String idUsuario;
    protected String contraseña;
    private char tipo;
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Planificador> planificadores = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
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

    public static boolean validarUsuario(String usuario, String contraseña) {

        for (Usuario i : listaUsuarios()) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                return true;
            }

        }

        return false;
    }

    public Date convertirFecha(String fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public static ArrayList<Usuario> listaUsuarios() {
        ArrayList<String> clientePlanificador = ManejoArchivos.LeeFichero("usuarios.txt");

        Cliente cl = null;
        for (String i : clientePlanificador) {
            String[] usu = i.split(";");
            String nombre = usu[0];
            String apellido = usu[1];

            String usuario = usu[2];
            String contraseña = usu[3];
            char tipo = usu[4].charAt(0);
            Usuario user = new Usuario(nombre, apellido, usuario, contraseña, tipo);
            usuarios.add(user);

            if (String.valueOf(user.tipo).equals("C")) {
                cl = new Cliente(nombre, apellido, usuario, contraseña, tipo);
                clientes.add(cl);
            } else {
                Planificador pl = new Planificador(nombre, apellido, usuario, contraseña, tipo);
                planificadores.add(pl);

            }

        }

        return usuarios;

    }
}
