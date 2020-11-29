
package Usuarios;


import Archivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;
import java.uti.Date;

/**
 *
 * @author alber
 */
public class Planificador extends Usuario {
    
    public Solicitud ConsultarSolicitudesPendientes(){
       ArrayList<String> soli = ManejoArchivos.LeeFichero("solicitudes.txt"); 
       ArrayList<Solicitud> solicitudes = new ArrayList<>();
       for (String i:soli){
           String[] sol=i.split(",");
           int id=sol[0];
           String cliente = sol[1];
           String planificador=sol[2];
           Date fecha= sol[3];
           
           return null;
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
