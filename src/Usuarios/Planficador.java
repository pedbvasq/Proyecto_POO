
package Usuarios;


import Archivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alber
 */
public class Planificador extends Usuario {
    
    ArrayList<Solicitud> solicitudes = new ArrayList<>();
       solicitudes = ManejoArchivos.LeeFichero("solicitudes.txt");
    public solicitud ConsultarSolicitudesPendientes(){
       
       for (Solicitud i:solicitudes){
           return i;
       }
       return null;
    }
    
    public void registrarEvento(){
        System.out.print("/********** REGIRTRO DE EVENTOS**********/\n"+"/*                                     */\n"+"/***************************************/\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese id del evento: ");
        String id = sc.nextLine();
        for (solicitud i: solicitudes){
            if (id == solicitud.getId()){
                System.out.println("DATOS");
                System.out.println("CLIENTE: "+solicitud.getCliente());
                System.out.println("PLANIFICADOR ASIGNADO: "+this.getNombre());
                System.out.println("FECHA DE REGISTRO: "+Solicitud.getFechaRegistro());
                System.out.println("TIPO: "+solicitud.getTipo());
                System.out.println("FECHA DEL EVENTO: "+solicitud.getFecha());
                System.out.println("PRECIO BASE: "+solicitud.getTarifa());
            }
        }
    }
}
