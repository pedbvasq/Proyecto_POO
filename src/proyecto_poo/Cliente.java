package proyecto_poo;

import Archivos.ManejoArchivos;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cliente extends Usuario {

    private String telefono;
    private String correo;
    Scanner sc = new Scanner(System.in);
    private ManejoArchivos file = null;
    private ArrayList<String> usu = file.LeeFichero("clientes.txt");
    GregorianCalendar calend = new GregorianCalendar();

    public Cliente(String telefono, String correo, String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
        this.telefono = telefono;
        this.correo = correo;
    }

    public void solicitarPlanificacionDeEvento() {
        String opcion = "";
        String fecha;
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
                    ValidarTiempo();

                    break;
                case "2":

                   
                    break;
                case "3":
                    

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

    //validamos la fecha ingresada por el usario, creando la sobrecarga de metodos validarTiempo()
    public void ValidarTiempo() {

        Date condicion;
        Date fechaDate;
        String fecha;

        do {
            System.out.println("Ingrese fecha(dd/MM/yyyy):");
            fecha = sc.nextLine();
            //Se convierte el dato  de string a date
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fechaDate = null;
            try {
                fechaDate = formato.parse(fecha);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
            //se aumentan 10 meses a la fecha Actual

            Calendar cal = Calendar.getInstance();
            Date fechaActual = new Date();
            cal.setTime(fechaActual);
            cal.add(cal.MONTH, 10);
            condicion = cal.getTime();

            if (fechaDate.after(condicion)) {
                System.out.println("Fecha del evento :" + fecha);
                System.out.println("Fecha valida!!");
            } else {
                System.out.println(" Fecha del evento :" + fecha);
                System.out.println("La fecha es muy proxima.Para este tipo de evento debemos tener\n" + "por lo menos 10 meses para planficar ingrese nuevamente.");
            }

        } while (fechaDate.after(condicion) == false);

    }

    public void ValidarTiempo(String fecha) {

    }

    public void ValidarTiempo(int fecha) {

    }

}
