package Main;

import Eventos.TipoEvento;
import Usuarios.Cliente;
import Usuarios.Planificador;
import Usuarios.Usuario;
import java.util.Scanner;

public class Sistema {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Llamada menu
        Sistema main = new Sistema();

        main.menu();

    }

    public void menu() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n"
                + "          BIENVENIDO AL SISTEMA\n" + "++++++++++++++++++++++++++++++++++++++++++++++");
        String usuario ;
        String contraseña;
        do {
            System.out.println("USUARIO:");
            usuario = sc.nextLine();
            System.out.println("CONTRASEÑA:");
            contraseña = sc.nextLine();

        } while (Usuario.validarUsuario(usuario, contraseña));
        

        Cliente Cl = Cliente.validarCliente(usuario, contraseña);
        if (String.valueOf(Cl.getTipo()).equals("C")) {
            String opcionC = "";

            while (!opcionC.equals("3")) {
                System.out.println("╔                Menu                       ");
                System.out.println("║ 1.Solicitar planificación de evento                   ║");
                System.out.println("║ 2. Registrar Pago de evento                  ");
                System.out.println("║ 3. Salir         ║");
                System.out.print("Ingrese opcion: ");
                opcionC = sc.nextLine();
                switch (opcionC) {
                    case "1":
                        System.out.println("Bienvenido "
                                + Cl.getNombre()
                                + " " + Cl.getApellido());
                        String opcionU = "";
                        String opcionSolicitud;
                        String fecha;

                        while (!opcionU.equals("4")) {
                            System.out.println("╔                TIPO DE EVENTO(Elija)                 ");
                            System.out.println("║ 1.Boda                  ║");
                            System.out.println("║ 2.Fiesta infantil                ");
                            System.out.println("║ 3. Fiesta empresarial         ║");
                            System.out.println("║ 4. Regresar a menu principal         ║");
                            System.out.print("Ingrese opcion: ");
                            opcionU = sc.nextLine();
                            switch (opcionU) {
                                case "1":
                                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                                    fecha = sc.nextLine();
                                    Cl.CondicionEvento(fecha);
                                    System.out.println("¿Desea ingresar su solictud?(S/N)");
                                    opcionSolicitud = sc.nextLine();
                                    Cl.crearSolicitud(opcionSolicitud, fecha, TipoEvento.BODA);

                                    break;
                                case "2":

                                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                                    fecha = sc.nextLine();
                                    Cl.CondicionEvento(fecha);
                                    System.out.println("¿Desea ingresar su solictud?(S/N)");
                                    opcionSolicitud = sc.nextLine();
                                    Cl.crearSolicitud(opcionSolicitud, fecha, TipoEvento.EMPRESARIAL);

                                    break;
                                case "3":
                                    System.out.println("Ingrese fecha(dd/MM/yyyy):");
                                    fecha = sc.nextLine();
                                    Cl.CondicionEvento(fecha);
                                    System.out.println("¿Desea ingresar su solictud?(S/N)");
                                    opcionSolicitud = sc.nextLine();
                                    Cl.crearSolicitud(opcionSolicitud, fecha, TipoEvento.INFANTIL);

                                    break;
                                case "4":
                                    opcionU = "4";

                                    break;

                                default:
                                    System.out.println("Opcion No valida!!");
                            }
                        }
                        sc.close();

                    case "2":
                        Cl.registrarPago();

                        break;
                    case "3":
                        opcionC = "3";
                        break;

                    default:
                        System.out.println("Opcion No valida!!");
                }
            }
            sc.close();

        } else {
            System.out.println("Cliente no encontrado");
        }

        Planificador Pl = Planificador.validarCliente(usuario, contraseña);

        if (String.valueOf(Pl.getTipo()).equals("P")) {
            String opcionP = "";
            while (!opcionP.equals("5")) {

                System.out.println("╔                Menu                       ");
                System.out.println("║ 1.Consultar solicitudes pendientes                   ║");
                System.out.println("║ 2.Registrar  evento                  ");
                System.out.println("║ 3.Confirmar evento         ║");
                System.out.println("║ 4.Consultar evento         ║");
                System.out.println("║ 5.Salir        ║");
                System.out.print("Ingrese opcion: ");
                opcionP = sc.nextLine();
                switch (opcionP) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":
                        opcionP = "5";
                        break;

                    default:
                        System.out.println("Opcion No valida!!");
                }
            }
            sc.close();

        } else {
            System.out.println("Planficador no encontrado..");
        }
    }

}
