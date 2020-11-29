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
    private Planificador user;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private Estado estado;
     private static ArrayList<Solicitud> solicitudes = new ArrayList<>();

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

    public Solicitud(int idSolicitud, Cliente cliente, Planificador user,Date fechaSolicitud ,Date fechaEvento) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.user = user;
         this.fechaSolicitud=fechaSolicitud;
        this.fechaEvento = fechaEvento;
        this.estado = estado.PENDIENTE;
    }
    public Solicitud(int idSolicitud, Cliente cliente, Planificador user,Date fechaSolicitud , Date fechaEvento,Estado estado) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.user = user;
        this.fechaSolicitud=fechaSolicitud;
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
                Usuario user = usuarios.get((int) aleatorio);
                Planificador p =new Planificador(user.getNombre(),user.getApellido(),user.getIdUsuario(),user.getContraseña(),user.getTipo());
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
