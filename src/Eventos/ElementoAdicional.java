
package Eventos;

import java.util.Scanner;


public abstract class ElementoAdicional {
    protected String tipo;
    protected  static double precioFinal;
    protected int cantidad;
    static Scanner sc = new Scanner(System.in);
  

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return
     */
    public abstract double establecerCantidad();

}


