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
        main.saludo();
        main.ValidacionUsurario();
        main.menuCliente();
    }
      //selecciona el tipo de usario que ingresa
    public void ValidacionUsurario() {
        char tipo;
        System.out.println("USUARIO:");
        String usuario = sc.nextLine();
        System.out.println("CONTRASEÑA:");
        String contraseña = sc.nextLine();

        for (Usuario i : listaUsuarios(usu)) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                String letra = String.valueOf(i.getTipo());
                if (letra == "C") {
                    menuCliente();
                } else {
                    menuPlanificador();

                }

            }

        }

    }

    //menu del cliente
    public void menuCliente() {
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

                    System.out.println("g");
                    break;
                case "2":
                    System.out.println("8");

                    break;
                case "3":
                    opcion = "3";
                    break;

                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        sc.close();
    }
//Lista de OBJETOS usuarios


    //saludo del programa
    public void saludo() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n" + "          BIENVENIDO AL SISTEMA\n" + "++++++++++++++++++++++++++++++++++++++++++++++");
    }

  

    //menu del planificador
    public void menuPlanificador() {
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

                    System.out.println("g");
                    break;
                case "2":
                    System.out.println("8");

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

    }
    
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

}
