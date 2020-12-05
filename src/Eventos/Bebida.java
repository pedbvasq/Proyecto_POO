package Eventos;


import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 * @author pedro elias wiliam
 */ 
public class Bebida extends ElementoAdicional {

    private final double Pwhisky = 50;
    private final double Pvodka = 25;
    private final double Pcerveza = 3;
    private final double Prefrescos = 1;
    
  
    @Override
    /**
     *  establece la cantidad dependiendo de lo que ingrese el usario
     */
    public void establecerCantidad() {
        int opcion;
        ArrayList<Integer> opcionesIngresadas= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int precioTotal = 0;
                
        do {
            

            int cantidad;

            System.out.println("Bebidas disponibles : \n" + "1.Whisky\n" + "2.Vodka\n" + "3.Cerveza\n" + "4.Refresco\n" + "5.Terminar");
            opcion = sc.nextInt();
            
            if (!opcionesIngresadas.contains(opcion)){
                opcionesIngresadas.add(opcion);
                switch (opcion) {
                    case 1:
                        System.out.println("Cantidad: ");
                        cantidad = sc.nextInt();
                        precioTotal += Pwhisky * cantidad;break;

                    case 2:
                        System.out.println("Cantidad: ");
                        cantidad = sc.nextInt();
                        precioTotal += Pvodka * cantidad;break;

                    case 3:
                        System.out.println("Cantidad: ");
                        cantidad = sc.nextInt();
                        precioTotal += Pcerveza * cantidad;break;

                    case 4:
                        System.out.println("Cantidad: ");
                        cantidad = sc.nextInt();
                        precioTotal += Pwhisky * cantidad;break;
                    case 5:
                        break;
                    
                    default:
                        System.out.println("Opcion no valida");
                                
                }
            }
                else {System.out.println("Opcion ya igresada, ingrese otra opcion");}
        } while (opcion!=5);
        
        sc.close();
        this.setPrecioFinal(precioTotal);

    }
}
