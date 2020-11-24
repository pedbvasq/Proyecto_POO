package Main;

import java.util.Scanner;
import java.util.ArrayList;
import Archivos.ManejoArchivos;
import proyecto_poo.Usuario;

public class Sistema {

    static ManejoArchivos file = null;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> usu = file.LeeFichero("usuarios.txt");

    public static void main(String[] args) {
        //Llamada menu
        Sistema main = new Sistema();

        main.listaUsuarios(usu);
        main.menu();
      
    }
  

    public void menu() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n" + "          BIENVENIDO AL SISTEMA\n" + "++++++++++++++++++++++++++++++++++++++++++++++");
        
        System.out.println("USUARIO:");
        String usuario = sc.nextLine();
        System.out.println("CONTRASEÑA:");
        String contraseña = sc.nextLine();

        for (Usuario i : listaUsuarios(usu)) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                String letra = String.valueOf(i.getTipo());
                
                if (letra == "C") {
                    String opcion = "";
                    while (!opcion.equals("3")) {
                        System.out.println("╔                Menu                       ");
                        System.out.println("║ 1.Solicitar planificación de evento                   ║");
                        System.out.println("║ 2. Registrar Pago de evento                  ");
                        System.out.println("║ 3. Salir         ║");
                        System.out.print("Ingrese opcion: ");
                        opcion = sc.nextLine();
                        switch (opcion) {
                            case "1":
                                solicitarPlanificacionDeEvento();
                                
                                break;
                            case "2":
                                registrarPagoDeEvento();
                                
                                break;
                            case "3":
                                opcion = "3";
                                break;

                            default:
                                System.out.println("Opcion No valida!!");
                        }
                    }
                    sc.close();

                } else {
                    String opcion = "";
                    while (!opcion.equals("5")) {
                        
                        System.out.println("╔                Menu                       ");
                        System.out.println("║ 1.Consultar solicitudes pendientes                   ║");
                        System.out.println("║ 2.Registrar  evento                  ");
                        System.out.println("║ 3.Confirmar evento         ║");
                        System.out.println("║ 4.Consultar evento         ║");
                        System.out.println("║ 5.Salir        ║");
                        System.out.print("Ingrese opcion: ");
                        opcion = sc.nextLine();
                        switch (opcion) {
                            case "1":

                                consultarSolicitudesPendientes();
                                break;
                            case "2":
                                registrarEvento();

                                break;
                            case "3":
                                confirmarEvento();

                                break;
                            case "4":
                                consultarEvento();

                                break;
                            case "5":
                                opcion = "5";
                                break;

                            default:
                                System.out.println("Opcion No valida!!");
                        }
                    }
                    sc.close();

                }

            }

        }

    }

    //LISTA DE USUARIOS
    public ArrayList<Usuario> listaUsuarios(ArrayList<String> a) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (String i : a) {
            String[] usu = i.split(";");
            String nombre = usu[0];
            String apellido = usu[1];

            String usuario = usu[2];
            String contraseña = usu[3];
            char tipo = usu[4].charAt(0);
            Usuario user = new Usuario(nombre, apellido, usuario, contraseña, tipo);
            usuarios.add(user);

        }

        return usuarios;

    }
    
    public void solicitarPlanificacionDeEvento(){
        
    }
    
    public void registrarPagoDeEvento(){
        
    }
    
    public void consultarSolicitudesPendientes(){
        
    }
    
    public void registrarEvento(){
        
    }
    
    public void confirmarEvento(){
        
    }
    
    public void consultarEvento(){
        
    }
    

}
