package Main;

import java.util.Scanner;
import proyecto_poo.Cliente;
import proyecto_poo.Usuario;

public class Sistema {

    static Scanner sc = new Scanner(System.in);
    static Usuario usu = new Usuario();

    public static void main(String[] args) {
        //Llamada menu
        Sistema main = new Sistema();

        main.menu();

    }

    public void menu() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n" + "          BIENVENIDO AL SISTEMA\n" + "++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("USUARIO:");
        String usuario = sc.nextLine();
        System.out.println("CONTRASEÑA:");
        String contraseña = sc.nextLine();
        String opcion = "";
        switch (String.valueOf(usu.validarUsuario(usuario, contraseña).getTipo())) {

            case "C":

                while (!opcion.equals("3")) {
                    System.out.println("╔                Menu                       ");
                    System.out.println("║ 1.Solicitar planificación de evento                   ║");
                    System.out.println("║ 2. Registrar Pago de evento                  ");
                    System.out.println("║ 3. Salir         ║");
                    System.out.print("Ingrese opcion: ");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        case "1":
                            System.out.println("Bienvenido " + usu.validarUsuario(usuario, contraseña).getNombre() + " " + usu.validarUsuario(usuario, contraseña).getApellido());

                            break;

                        case "2":

                            break;
                        case "3":
                            opcion = "3";
                            break;

                        default:
                            System.out.println("Opcion No valida!!");
                    }
                }
                sc.close();
                break;
            case "P":

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

                            break;
                        case "2":

                            break;
                        case "3":

                            break;
                        case "4":

                            break;
                        case "5":
                            opcion = "5";
                            break;

                        default:
                            System.out.println("Opcion No valida!!");
                    }
                }
                sc.close();

                break;
            default:
                System.out.println("Usuario o contraseña No valida!!");

        }

    }
}
