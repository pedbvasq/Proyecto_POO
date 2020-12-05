
package Eventos;


import java.util.ArrayList;
import java.util.Scanner;
public class Musica extends ElementoAdicional {
    private final double precioDj = 300;
    private final double precioBanda = 2000;
    private String tipo;
    private String tipo1;
    private String tipo2;

    
    public String getTipo(){return tipo;}
    public String getTipo1(){return tipo1;}
    public String getTipo2(){return tipo2;}
    
    @Override
    public void establecerCantidad() {
        int opcion;
        ArrayList<Integer> opcionesAgregadas = new ArrayList<>();
        
        do{
            
            Scanner sc = new Scanner(System.in);
            double contadorPrecio=0;
            System.out.println("Musica Disponible : \n" + "1.Dj($300)" + "2.Banda($2000)"+"3.Omitir");
            System.out.println("¿Que prefiere?");
            opcion =sc.nextInt();
            if(!opcionesAgregadas.contains(opcion)){
                opcionesAgregadas.add(opcion);
                switch (opcion){
                    case 1:
                        this.setCantidad(this.getCantidad()+1);
                        contadorPrecio+=precioDj;
                        this.tipo="DJ";
                        this.tipo1="DJ";
                        break;
                    case 2:
                        this.setCantidad(this.getCantidad()+1);
                        contadorPrecio+=precioBanda;
                        this.tipo="BANDA";
                        this.tipo2="BANDA";
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("¡Opcion no válida!");
                } 
            sc.close();
            }else{System.out.println("Opcion ya ingresada. Intente nuevamente.");}
        }while (opcion!=3||this.getCantidad()!=2);
        
    }    
}
