package Archivos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Solicitud {

    private int idSolicitud;
    private Cliente cliente;
    private Planficador user;

    
    private Date fechaEvento;
    private Estado estado;
    ArrayList<Solicitud> solicitudes = new ArrayList<>();
    
    public Solicitud(int idSolicitud, Cliente cliente, Date fechaEvento, Estado estado) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.fechaEvento = fechaEvento;
        this.estado = estado;
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

    public Planficador getUser() {
        return user;
    }

    public void setUser(Planficador user) {
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

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
    

    private Usuario elegirPlanificador() {
        ArrayList<String> usu = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<Usuario> usuarios = Usuario.listaUsuarios();
        double aleatorio = 0;
        for (Usuario i : usuarios) {
            if (String.valueOf(i.getTipo()).equals("P")) {
                aleatorio = Math.random() * usuarios.size();
                Usuario user = usuarios.get((int) aleatorio);
                return user;

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
