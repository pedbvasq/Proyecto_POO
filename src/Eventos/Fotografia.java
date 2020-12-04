
package Eventos;

public class Fotografia extends ElementoAdicional {
    private final double Pfoto = 500;

      
    @Override
    public void establecerCantidad() {
       this.setCantidad(1);
       this.setPrecioFinal(Pfoto);
    }
    
    
}
