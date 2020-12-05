
package Eventos;

import java.util.Scanner;
/**
 * 
 * @author pedro elias wiliam
 */
public abstract class ElementoAdicional {
    
    static Scanner sc = new Scanner(System.in);
    private int cantidad;
    private double precioFinal;//precio total a pagar 
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precio) {
        this.precioFinal = precio;
    }
    /**
     * metodo estatico 
     */
    public abstract void establecerCantidad();
}
