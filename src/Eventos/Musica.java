
package Eventos;


public class Musica extends ElementoAdicional {
    private final double precioDj = 300;
    private final double precioBanda = 300;
    

    @Override
    public double establecerCantidad() {
        String opcion;
        System.out.println("Musica Disponible : \n" + "1.Dj($300)" + "2.Banda($2000)"+"3.Regresar");
        System.out.println("¿Que prefiere ?");
        opcion =sc.nextLine();
        if(opcion.equals("1")){
            
             
        }
        return 0;
        
                
                
      
    }
    
    
}
