package Usuarios;

import Archivos.ManejoArchivos;
import Archivos.OrdenDePago;
import Archivos.Solicitud;
import Eventos.Evento;
import Eventos.TipoEvento;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente extends Usuario {

    private String telefono;
    private String correo;
    private static Date fechaEvento;
    

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

    public void condicionEvento(String opcion) {
        String fecha;

        do {

            System.out.println("Ingrese fecha(dd/MM/yyyy):");
            fecha = sc.nextLine();
            if (validarTiempo(fecha, opcion)) {
                System.out.println("Fecha del evento :" + fecha);
                System.out.println("Fecha valida!!");
                System.out.println("Ha registrado los datos necesarios para la solicitud.");
                break;

            } else {
                System.out.println(" Fecha del evento :" + fecha);
                System.out.println("La fecha es muy proxima.Para este tipo de evento debemos tener\n" + "por lo menos 10 meses  para planficar ingrese nuevamente.");

            }

        } while (validarTiempo(fecha, opcion) == false);

    }

    public Boolean validarTiempo(String fecha, String opcion) {
        Date fecha1 = convertirFecha(fecha);
        Date condicion;
        Calendar cal = Calendar.getInstance();
        Date fechaActual = new Date();

        switch (opcion) {
                         case "1":

                cal.setTime(fechaActual);
                cal.add(cal.MONTH, 10);
                condicion = cal.getTime();
                if (fecha1.after(condicion)) {
                    Cliente.fechaEvento = fecha1;
                    return true;
                } else {
                    return false;
                }

            case "2":
                cal.setTime(fechaActual);
                cal.add(cal.MONTH, 2);
                condicion = cal.getTime();
                if (fecha1.after(condicion)) {
                    Cliente.fechaEvento = fecha1;
                    return true;

                } else {
                    return false;
                }

            case "3":
                cal.setTime(fechaActual);
                cal.add(cal.DATE, 14);
                condicion = cal.getTime();
                if (fecha1.after(condicion)) {
                    Cliente.fechaEvento =  fecha1;
                    return true;
                } else {
                    return false;
                }

            default:
                System.out.println("opcion");
        }
        return null;

    }

    public void crearSolicitud(String opcion, TipoEvento ev) {
        Date fechaActual = new Date();
        if (opcion.startsWith("s") || opcion.startsWith("S")) {
            int codigo = Solicitud.generarID();
            Planificador planificador = Solicitud.elegirPlanificador();
            String nameC = this.nombre;
            String fecha1 = String.valueOf(fechaActual.getDay()) + "/" + String.valueOf(fechaActual.getMonth()) + "/" + String.valueOf(fechaActual.getYear());
            String total = codigo + "," + nameC + "," + planificador.nombre + "," + fecha1 + "," + Cliente.fechaEvento + "," + "Pendiente";
            ManejoArchivos.EscribirArchivo("solicitudes.txt", total);
            Solicitud st = new Solicitud(codigo,this,planificador,fechaActual,fechaEvento,ev);
            st.añadirSolicitud(st);
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
