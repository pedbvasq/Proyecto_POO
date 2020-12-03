package Usuarios;

import Archivos.ManejoArchivos;
import Archivos.OrdenDePago;
import Archivos.Solicitud;
import Eventos.Evento;
import Eventos.TipoEvento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cliente extends Usuario {

    private String telefono;
    private String correo;

    GregorianCalendar calend = new GregorianCalendar();
    static TipoEvento e;

    public Cliente(String telefono, String correo, String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
    }

    public void CondicionEvento(String fecha) {
        

        Date fechaActual = new Date();
        do {
            if (fechaActual.after(validarTiempo(fecha))) {
                System.out.println("Fecha del evento :" + fecha);
                System.out.println("Fecha valida!!");

            } else {
                System.out.println(" Fecha del evento :" + fecha);
                System.out.println("La fecha es muy proxima.Para este tipo de evento debemos tener\n" + "por lo menos 10 meses  para planficar ingrese nuevamente.");
            }
            if (fechaActual.after(validarTiempo(fecha))) {
                System.out.println(" Fecha del evento :" + fecha);

            } else {
                System.out.println("La fecha es muy proxima.Para este tipo de evento debemos tener\n" + "por lo menos 3 semanas para planficar ingrese nuevamente.");

            }
            if (fechaActual.after(validarTiempo(fecha))) {
                System.out.println("Fecha del evento :" + fecha);
                System.out.println("Fecha valida!!");

            } else {
                System.out.println("La fecha es muy proxima.Para este tipo de evento debemos tener\n" + "por lo menos 2 meses para planficar ingrese nuevamente.");

            }

        } while (fechaActual.after(validarTiempo(fecha)) == false);
    }

    private Date validarTiempo(String fecha) {
        Date fecha1 = convertirFecha(fecha);
        Date condicion;
        Calendar cal = Calendar.getInstance();

        switch (e) {
            case BODA:

                cal.setTime(fecha1);
                cal.add(cal.MONTH, 10);
                condicion = cal.getTime();
                return condicion;

            case EMPRESARIAL:
                cal.setTime(fecha1);
                cal.add(cal.MONTH, 10);
                condicion = cal.getTime();
                return condicion;

            case INFANTIL:
                cal.setTime(fecha1);
                cal.add(cal.DATE, 2);
                condicion = cal.getTime();
                return condicion;
        }
        return null;

    }

    public void crearSolicitud(String opcion, String fecha, TipoEvento ev) {
        Date fechaActual = new Date();
        if (opcion.startsWith("s") || opcion.startsWith("S")) {
            int codigo = Solicitud.generarID();
            Planificador planificador = Solicitud.elegirPlanificador();
            String nameC = this.nombre;
            String fecha1 = String.valueOf(fechaActual.getDay()) + "/" + String.valueOf(fechaActual.getMonth()) + "/" + String.valueOf(fechaActual.getYear());
            String total = codigo + "," + nameC + "," + planificador + "," + fecha1 + "," + fecha + "," + "Pendiente";
            Solicitud st = new Solicitud(codigo, this, planificador, fechaActual, validarTiempo(fecha), ev);
            String cod = String.valueOf(st.getIdSolicitud());

            String nameP = st.getUser().nombre;

            st.añadirSolicitud(st);
            ManejoArchivos.EscribirArchivo("solicitudes.txt", total);
            System.out.print("/********** SOLICITUD REGISTRADA**********/\n" + "/*                                     */\n" + "/***************************************/\n");
            System.out.println("DATOS");
            System.out.println("CLIENTE: " + st.getCliente().nombre);
            System.out.println("PLANIFICADOR ASIGNADO: " + this.getNombre());
            System.out.println("FECHA DE REGISTRO: " + st.getFechaSolicitud());
            System.out.println("TIPO: " + st.getTipo());
            System.out.println("FECHA DEL EVENTO: " + st.getFechaEvento());
            System.out.println("** se ha registrado su solicitud pronto el planificador se se contactara "
                    + "con usted por telefono o video conferencia para completar el proceso de recoleccion de datos");
        } else {
            System.out.println("Solicitud cancelada");

        }

    }

    public void registrarPago() {
        String opcion;
        String codTransaccion;
        Date fechaActual = new Date();
        System.out.print("/**********SOLICITUDES PENDIENTES*********/\n" + "/* "
                + "                                     "
                + " */\n" + "/*****************************************/\n");
        String cod = Evento.generarCodigo();
        System.out.println("Su orden con codigo " + cod + "esta pendiente de pago");
        System.out.println("¿Desea registar su pago ahora?(S/N) : ");
        opcion = sc.nextLine();
        System.out.println("Ingrese codigo de la transaccion : ");
        codTransaccion = sc.nextLine();
        OrdenDePago op = new OrdenDePago(cod, codTransaccion, fechaActual);
        System.out.println("Listo, se ha registrado cuando el planificador valide el se pondra en contacto con usted. ");

    }

    public static Cliente validarCliente(String usuario, String contraseña) {
        
        for (Cliente i : clientes) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                return i;

            }
        }
        return null;

    }

}
