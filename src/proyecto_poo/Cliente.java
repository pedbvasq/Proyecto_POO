
package proyecto_poo;

import Archivos.ManejoArchivos;

import java.util.ArrayList;
import java.util.Scanner;



public class Cliente extends Usuario {
    private String telefono;
    Scanner sc = new Scanner(System.in);


   
    private String correo;
    private ManejoArchivos file = null;
    private ArrayList<String> usu = file.LeeFichero("clientes.txt");
    
     public Cliente(String telefono, String correo, String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
        this.telefono = telefono;
        this.correo = correo;
    }
     
     public  void menuEvento(){
         String opcion ="";
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
                            validarTiempo();
                            System.out.println("k");

                            break;
                        case "2":
                             validarTiempo();
                             System.out.println("kg");

                            break;
                        case "3":
                            validarTiempo();
                            System.out.println("kfgd");
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

    public Cliente() {
    }
     
     public void validarTiempo(){
         
     }

   
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
