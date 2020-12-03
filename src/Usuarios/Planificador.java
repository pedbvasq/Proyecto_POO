package Usuarios;

import Archivos.Estado;
import Archivos.ManejoArchivos;
import Archivos.OrdenDePago;
import Archivos.Solicitud;
import Eventos.Evento;
import Eventos.TipoEvento;
import static Eventos.TipoEvento.BODA;
import static Eventos.TipoEvento.EMPRESARIAL;
import static Eventos.TipoEvento.INFANTIL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Planificador extends Usuario {


    public Planificador(String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
    }

    public Planificador() {

    }

    public void ConsultarSolicitudesPendientes() {
        ArrayList<String> solicitudes = ManejoArchivos.LeeFichero("solicitudes.txt");
        System.out.print("/**********SOLICITUDES PENDIENTES*********/\n" + "/*                                       */\n" + "/*****************************************/\n");
        int num = 0;
        for (String i : solicitudes) {
            String[] sol = i.split(",");
            String id = sol[0];
            String fecha = sol[3];
            num++;
            System.out.println(num + ". " + id + " - " + fecha);
        }
    }

    public void registrarEvento() {
        System.out.print("/********** REGIRTRO DE EVENTOS**********/\n" + "/*  "
                + "                                   */\n" + "/***************************************/\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<Solicitud> solicitudes = Solicitud.getSolicitudes();
        System.out.print("Ingrese id del evento: ");
        int id = sc.nextInt();
        for (Solicitud i : solicitudes) {
            if (id == i.getIdSolicitud()) {
                System.out.println("DATOS");
                System.out.println("CLIENTE: " + i.getCliente().getNombre());
                System.out.println("PLANIFICADOR ASIGNADO: " + this.getNombre());
                System.out.println("FECHA DE REGISTRO: " + i.getFechaEvento());
                System.out.println("TIPO: ");
                System.out.println("FECHA DEL EVENTO: " + i.getFechaEvento());
                switch (i.getTipo()) {
                    case BODA:
                        System.out.println("Precio Base: 3500");

                    case EMPRESARIAL:
                        System.out.println("Precio Base: 2000");

                    case INFANTIL:
                        System.out.println("Precio Base: 300");

                }
            }

        }

    }

    public void confirmarEvento() {
        System.out.print("/********** CONFIRMAR EVENTO **********/\n" + "/*  "
                + "                                   */\n" + "/***************************************/\n");
        String cod;
        System.out.println("Ingrese el ID de la orden de pago");
        cod = sc.nextLine();
        for (OrdenDePago i : OrdenDePago.getPagos()) {
            if (cod.equals(i.getCodigoOrden())) {
                System.out.println("El pago de este evento se ha realizo el : " + i.getFechaActual());
                i.setEstado(Estado.APROBADA);
                System.out.println("El evento se ha aprobado para la fecha establecida");

            }
        }

    }

    public void ConsultarEvento(String opcion) {

        switch (opcion) {
            case "1":
                System.out.println("Tiene " + filtro(BODA) + " Fiestas infantiles asigandas");

            case "2":
                System.out.println("Tiene " + filtro(INFANTIL) + " Fiestas infantiles asigandas");

            case "3":
                System.out.println("Tiene " + filtro(EMPRESARIAL) + " Fiesta empresarial asiganda");

            default:
                System.out.println("Opcion invalida!!!!");

        }

    }

    public int filtro(TipoEvento evento) {
        int acum = 0;
        ArrayList<Evento> eventos = Evento.getEventos();
        for (Evento e : eventos) {
            if (e.getCodigo().getClass().equals(evento)) {
                if (e.getPlanificador().nombre.contentEquals(this.nombre)) {
                    acum++;

                }

            }

        }
        return acum;

    }

    public void crearEvento(Date horaInicio, Date horaFin, int capacidad, char desicion) {
        ArrayList<Solicitud> solicitudes = Solicitud.getSolicitudes();
        for (Solicitud i : solicitudes) {
            Evento evento = new Evento(i.getTipo(), i.getFechaEvento(), Evento.generarCodigo(), i.getCliente(), horaInicio, horaFin, capacidad, desicion, i.getUser());
            Evento.agregarEvento(evento);

        }

    }

    public static Planificador validarCliente(String usuario, String contraseña) {
        for (Planificador i : planificadores) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                return i;

            }
        }
        return null;

    }

}
