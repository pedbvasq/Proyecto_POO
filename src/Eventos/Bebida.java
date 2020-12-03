package Eventos;

import java.util.Scanner;

public class Bebida extends ElementoAdicional {

    private final double Pwhisky = 50;
    private final double Pvodka = 25;
    private final double Pcerveza = 3;
    private final double Prefrescos = 1;

    @Override
    public double establecerCantidad() {
        String opcion;
        int precioTotal = 0;
        do {

            int cantidad = 0;

            System.out.println("Bebidas disponibles : \n" + "1.Whisky\n" + "2.Vodka\n" + "3.Cerveza\n" + "4.Refresco" + "5.Regresar");
            opcion = sc.nextLine().toLowerCase();
            switch (opcion) {
                case "1":
                    System.out.println("Cantidad : ");
                    cantidad = sc.nextInt();
                    precioTotal += Pwhisky * cantidad;

                case "2":
                    System.out.println("Cantidad : ");
                    cantidad = sc.nextInt();
                    precioTotal += Pvodka * cantidad;

                case "3":
                    System.out.println("Cantidad : ");
                    cantidad = sc.nextInt();
                    precioTotal += Pcerveza * cantidad;

                case "4":
                    System.out.println("Cantidad : ");
                    cantidad = sc.nextInt();
                    precioTotal += Pwhisky * cantidad;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion.equals(""));
        return precioTotal;

    }

}
