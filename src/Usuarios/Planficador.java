
package Usuarios;


import Archivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;
import java.uti.Date;

/**
 *
 * @author alber
 */
public void ConsultarSolicitudesPendientes(){
       ArrayList<String> solicitudes = ManejoArchivos.LeeFichero("solicitudes.txt"); 
       System.out.print("/**********SOLICITUDES PENDIENTES*********/\n"+"/*                                       */\n"+"/*****************************************/\n");
       int num=0;
       for (String i:solicitudes){
           String[] sol=i.split(",");
           String id=sol[0];
           String fecha = sol[3];
           num++;
           System.out.println(num+". "+id+" - "+fecha);
        }       
    }
    
    ArrayList<Solicitud> solicitudes = Solicitud.getSolicitudes();
    public void registrarEvento(){
        System.out.print("/********** REGIRTRO DE EVENTOS**********/\n"+"/*                                     */\n"+"/***************************************/\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese id del evento: ");
        int id = sc.nextInt();
        for (Solicitud i: solicitudes){
            if (id == i.getIdSolicitud()){
                System.out.println("DATOS");
                System.out.println("CLIENTE: "+i.getEvento().getCliente().getNombre());
                System.out.println("PLANIFICADOR ASIGNADO: "+this.getNombre());
                System.out.println("FECHA DE REGISTRO: "+i.getFechaRegistro());
                System.out.println("TIPO: "+i.getEvento().getTipo());
                System.out.println("FECHA DEL EVENTO: "+i.getEvento().getFecha());
                System.out.println("PRECIO BASE: "+i.getEvento().getTarifa());
            }
        }
    }
}
