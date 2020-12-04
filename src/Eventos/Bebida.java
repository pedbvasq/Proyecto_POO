package Eventos;

import java.util.Scanner;

public class Bebida extends ElementoAdicional {

    private final double Pwhisky = 50;
    private final double Pvodka = 25;
    private final double Pcerveza = 3;
    private final double Prefrescos = 1;

    @Override
    public double establecerCantidad() {
        int opcion;
        int precioTotal = 0;
        String sn = null;
        do {

            int cantidad = 0;

            System.out.println("Bebidas disponibles : \n" + "1.Whisky\n" + "2.Vodka\n" + "3.Cerveza\n" + "4.Refresco" + "5.Regresar");
            opcion = sc.nextInt();

            int botellas[] = new int[3];
            if (botellas[opcion] == 0) {

                switch (opcion) {

                    case 1:
                        System.out.println("Cantidad : ");
                        cantidad = sc.nextInt();
                        precioTotal += Pwhisky * cantidad;
                        System.out.println("¿ Desea seguir agregando?");
                        sn = sc.nextLine();
                        System.out.println("");

                    case 2:
                        System.out.println("Cantidad : ");
                        cantidad = sc.nextInt();
                        precioTotal += Pvodka * cantidad;
                        System.out.println("¿ Desea seguir agregando?");
                        sn = sc.nextLine().toLowerCase();

                    case 3:
                        System.out.println("Cantidad : ");
                        cantidad = sc.nextInt();
                        precioTotal += Pcerveza * cantidad;
                        System.out.println("¿ Desea seguir agregando?");
                        sn = sc.nextLine().toLowerCase();

                    case 4:
                        System.out.println("Cantidad : ");
                        cantidad = sc.nextInt();
                        precioTotal += Pwhisky * cantidad;
                        System.out.println("¿ Desea seguir agregando?");
                        sn = sc.nextLine().toLowerCase();

                    default:
                        System.out.println("Opcion no valida");

                }

            } else {
                System.out.println("Ya no puede seleccionar ese elemento.");
            }

        } while (!sn.equals("n"));
        return precioTotal;

    }

}
