package Usuarios;

import Archivos.ManejoArchivos;
import Archivos.Solicitud;
import Eventos.TipoEvento;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Cliente extends Usuario {

    private String telefono;
    private String correo;
    Scanner sc = new Scanner(System.in);
    private ManejoArchivos file = null;
    private ArrayList<String> usu = file.LeeFichero("clientes.txt");
    GregorianCalendar calend = new GregorianCalendar();
    static TipoEvento e;

    public Cliente(String telefono, String correo, String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
        this.telefono = telefono;
        this.correo = correo;
    }

    public void solicitarPlanificacionDeEvento() {
        String opcion = "";
        String fecha;
        String opcion1;

        while (!opcion.equals("4")) {
            System.out.println("╔                TIPO DE EVENTO(Elija)                 ");
            System.out.println("║ 1.Boda                  ║");
            System.out.println("║ 2.Fiesta infantil                ");
            System.out.println("║ 3. Fiesta empresarial         ║");
            System.out.println("║ 4. Regresar a menu principal         ║");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                    fecha = sc.nextLine();
                    CondicionEvento(fecha);
                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                    opcion1 = sc.nextLine();
                    crearSolicitud(opcion1, fecha);

                    break;
                case "2":
                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                    fecha = sc.nextLine();
                    CondicionEvento(fecha);
                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                    opcion1 = sc.nextLine();
                    crearSolicitud(opcion1, fecha);

                    break;
                case "3":
                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                    fecha = sc.nextLine();
                    CondicionEvento(fecha);
                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                    opcion1 = sc.nextLine();
                    crearSolicitud(opcion1, fecha);

                    break;
                case "4":
                    opcion = "4";

                    break;

                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        sc.close();
    }

    private void CondicionEvento(String fecha) {

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



    private static Date validarTiempo(String fecha) {
        Date condicion;
        Date fechaActual = new Date();
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        //se aumentan 10 meses a la fecha Actual
        switch (e) {
            case BODA:

                cal.setTime(fechaActual);
                cal.add(cal.MONTH, 10);
                condicion = cal.getTime();
                return condicion;

            case EMPRESARIAL:
                cal.setTime(fechaActual);
                cal.add(cal.MONTH, 10);
                condicion = cal.getTime();
                return condicion;

            case INFANTIL:
                cal.setTime(fechaActual);
                cal.add(cal.DATE, 2);
                condicion = cal.getTime();
                return condicion;
        }
        return null;

    }

    public void crearSolicitud(String opcion, String fecha) {
        Date fechaActual = new Date();
        if (opcion.startsWith("s") || opcion.startsWith("S")) {
            int codigo = Solicitud.generarID();
            Planificador planificador = Solicitud.elegirPlanificador();
            Solicitud st = new Solicitud(codigo, this, planificador, fechaActual, validarTiempo(fecha));
            st.getSolicitudes().add(st);
            String cod = String.valueOf(st.getIdSolicitud());
            String nameC = this.nombre;
            String nameP = st.getUser().nombre;
            String fecha1 = String.valueOf(fechaActual.getDay()) + "/" + String.valueOf(fechaActual.getMonth()) + "/" + String.valueOf(fechaActual.getYear());
            String total = cod + "," + nameC + "," + nameP + "," + fecha1 + "," + fecha + "," + st.getEstado();
            ManejoArchivos.EscribirArchivo("solicitudes.txt", total);
            System.out.print("/********** SOLICITUD REGISTRADA**********/\n" + "/*                                     */\n" + "/***************************************/\n");
            System.out.println("DATOS");
            System.out.println("CLIENTE: " + st.getCliente().nombre);
            System.out.println("PLANIFICADOR ASIGNADO: " + this.getNombre());
            System.out.println("FECHA DE REGISTRO: " + st.getFechaSolicitud());
            System.out.println("TIPO: " + st.getEstado());
            System.out.println("FECHA DEL EVENTO: " + st.getFechaEvento());
            System.out.println("** se ha registrado su solicitud pronto el planificador se se contactara "
                    + "con usted por telefono o video conferencia para completar el proceso de recoleccion de datos");
        } else {
            System.out.println("Solicitud cancelada");

        }

    }

}
