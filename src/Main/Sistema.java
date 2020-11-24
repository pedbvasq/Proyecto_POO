
package Main;

import java.util.Scanner;


public class Sistema {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Llamada menu
        Sistema main = new Sistema();
        
        main.saludo();
        main.ValidacionUsurario();
        main.menuCliente();
        
    }
   //saludo del programa
  public void saludo(){
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n"+"          BIENVENIDO AL SISTEMA\n"+"++++++++++++++++++++++++++++++++++++++++++++++");
  }
    //selecciona el tipo de usario que ingresa
    public void ValidacionUsurario(){
       char tipo;
       System.out.println("USUARIO:");
       String usuario = sc.nextLine();
       System.out.println("CONTRASEÑA:");
       String contraseña = sc.nextLine();   
       
    }
     //menu del cliente
     public void menuCliente(){
        String opcion="";
        while(!opcion.equals("3")){
              System.out.println("╔                Menu                       ");
              System.out.println("║ 1.Solicitar planificación de evento                   ║");
              System.out.println("║ 2. Registrar Pago de evento                  ");
              System.out.println("║ 3. Salir         ║");
              System.out.print("Ingrese opcion: ");      
              opcion = sc.nextLine();          
            switch (opcion){
                case "1":
                   menuEvento();
                   System.out.println("g");
                    break;
                case "2":
                    System.out.println("8");
                   
                    break;
                case "3": 
                    opcion="3";
                    break;
                
                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        sc.close();
    }
     //menu del evento
     public void menuEvento(){
       
    
     }
     
    
}

    
     
      