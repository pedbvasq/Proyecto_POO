package Archivos;

import Eventos.TipoEvento;
import Usuarios.Cliente;
import Usuarios.Planificador;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Solicitud {

    private int idSolicitud;
    private Cliente cliente;
    private Planificador user;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private Estado estado;
    private TipoEvento tipo;
    private static ArrayList<Solicitud> solicitudes = new ArrayList<>();
     ArrayList<String> solicitudesArchivo = ManejoArchivos.LeeFichero("solicitudes.txt");
    static Planificador p;

    public Solicitud(int idSolicitud, Cliente cliente, Planificador user, Date fechaSolicitud, Date fechaEvento, TipoEvento tipo) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEvento = fechaEvento;
        this.tipo = tipo;
        this.estado = estado.PENDIENTE;
        this.user = user;
    }

    public static ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public static void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        Solicitud.solicitudes = solicitudes;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }


    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Planificador getUser() {
        return user;
    }

    public void setUser(Planificador user) {
        this.user = user;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public static Planificador elegirPlanificador() {
        ArrayList<String> usu = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<Usuario> usuarios = Usuario.listaUsuarios();
        double aleatorio = 0;
        for (Usuario i : usuarios) {
            if (String.valueOf(i.getTipo()).equals("P")) {
                aleatorio = Math.random() * usuarios.size();
                Planificador p = Usuario.planificadores.get((int) aleatorio);
                return p;
            }
        }
        return null;
    }

    public static int generarID() {
        Random r = new Random();
        return r.nextInt(1000);
    }

    public void añadirSolicitud(Solicitud solicitud) {

        solicitudes.add(solicitud);

    }
}
