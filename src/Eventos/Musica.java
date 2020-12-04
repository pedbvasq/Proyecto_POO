
package Eventos;


import java.util.Scanner;
public class Musica extends ElementoAdicional {
    private final double precioDj = 300;
    private final double precioBanda = 2000;
    

    @Override
    public void establecerCantidad() {
        this.setCantidad(1);
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Musica Disponible : \n" + "1.Dj($300)" + "2.Banda($2000)"+"3.Omitir");
        System.out.println("¿Que prefiere?");
        opcion =sc.nextInt();
        switch (opcion){
            case 1:
                this.setPrecioFinal(precioDj);
                break;
            case 2:
                this.setPrecioFinal(precioBanda);
                break;
            case 3:
                break;
        } 
    }    
}
