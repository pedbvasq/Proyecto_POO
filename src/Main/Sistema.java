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
        String usuario;
        String contraseña;
        do {
            System.out.print("USUARIO:");
            usuario = sc.nextLine();
            System.out.print("CONTRASEÑA:");
            contraseña = sc.nextLine();

        } while (Usuario.validarUsuario(usuario, contraseña) == false); //validando credenciales
        
            //pregunto si cliente o planificador
        if (String.valueOf(Usuario.tipo(usuario, contraseña)).equals("C")) {
            String opcionC = "";
            Cliente Cl = Cliente.validarCliente(usuario, contraseña);

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
                        while (!opcionU.equals("4")) {
                            System.out.println("╔                TIPO DE EVENTO(Elija)                 ");
                            System.out.println("║ 1.Boda                  ║");
                            System.out.println("║ 2.Fiesta infantil                ");
                            System.out.println("║ 3. Fiesta empresarial         ║");
                            System.out.println("║ 4. Regresar a menu principal         ║");
                            System.out.print("Ingrese opcion: ");
                            opcionU = sc.nextLine();
                            String fecha;
                            String opcionSoli;
                            switch (opcionU) {
                                case "1":
                                    Cl.condicionEvento("1");
                                    System.out.println("¿Desea ingresar su solicitud ?(S/N)");
                                    opcionSoli = sc.nextLine().toLowerCase();
                                    Cl.crearSolicitud(opcionSoli, TipoEvento.BODA);
                                    break;

                                case "2":
                                    Cl.condicionEvento("2");
                                    System.out.println("¿Desea ingresar su solicitud ?");
                                    opcionSoli = sc.nextLine().toLowerCase();
                                    Cl.crearSolicitud(opcionSoli, TipoEvento.INFANTIL);
                                    break;

                                case "3":
                                    Cl.condicionEvento("3");
                                    System.out.println("¿Desea ingresar su solicitud ?");
                                    opcionSoli = sc.nextLine().toLowerCase();
                                    Cl.crearSolicitud(opcionSoli, TipoEvento.INFANTIL);
                                    break;

                                case "4":
                                    System.out.println("Regresando...");
                                    break;

                                default:
                                    System.out.println("Opcion No valida!!");
                            }
                        }
                        //sc.close();
                        
                        break;

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

            Planificador Pl = Planificador.validarCliente(usuario, contraseña);
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
                        break;
                }
            }
            sc.close();

        }

    }
}


