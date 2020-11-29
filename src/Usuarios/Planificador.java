package Usuarios;

import Archivos.ManejoArchivos;
import Archivos.Solicitud;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Planificador extends Usuario{

    public Planificador(String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
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
        System.out.print("/********** REGIRTRO DE EVENTOS**********/\n" + "/*                                     */\n" + "/***************************************/\n");
        Scanner sc = new Scanner(System.in);
         ArrayList<Solicitud> solicitudes =Solicitud.solicitudes;
        System.out.print("Ingrese id del evento: ");
        int id = sc.nextInt();
        for (Solicitud i : solicitudes) {
            if (id == i.getIdSolicitud()) {
                System.out.println("DATOS");
                System.out.println("CLIENTE: " + i.getCliente().getNombre());
                System.out.println("PLANIFICADOR ASIGNADO: " + this.getNombre());
                System.out.println("FECHA DE REGISTRO: " + i.getFechaEvento());
                System.out.println("TIPO: " );
                System.out.println("FECHA DEL EVENTO: " + i.getFechaEvento());
                System.out.println("PRECIO BASE: " );
            }
        }
    }

}
