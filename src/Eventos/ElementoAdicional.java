
package Eventos;

public abstract class ElementoAdicional {
    
    
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
    
    public abstract void establecerCantidad();
}
