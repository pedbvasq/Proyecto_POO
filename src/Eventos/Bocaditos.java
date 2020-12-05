package Eventos;

import java.util.Scanner;
/**
 * 
 * @author pedro
 */

public class Bocaditos extends ElementoAdicional {

    private final double precioBocaditos = 0.25;
    private final double preciosPromociones = 0.10;

    @Override
    /**
     * establece la cantidad dependiendo de lo que ingrese el usario
     */
    public void establecerCantidad() {
        Scanner sc = new Scanner(System.in);
        int cantidad;
        System.out.println("Cuantos bocaditos desea");
        cantidad = sc.nextInt();
        super.setCantidad(cantidad);
        if (cantidad > 150) {
            this.setPrecioFinal(precioBocaditos * cantidad);

        } else {
            this.setPrecioFinal(preciosPromociones * cantidad);
        }
        sc.close();
    }

}
