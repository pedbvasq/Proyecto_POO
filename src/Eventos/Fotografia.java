
package Eventos;
/**
 * 
 * @author pedro elias wiliam
 */
public class Fotografia extends ElementoAdicional {
    private final double Pfoto = 500;
/**
 * establece la cantidad dependiendo de lo que ingrese el usario
 */
      
    @Override
    public void establecerCantidad() {
       this.setCantidad(1);
       this.setPrecioFinal(Pfoto);
    }
    
    
}
