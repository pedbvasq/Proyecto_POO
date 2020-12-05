
package Eventos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.Date;

/**
 * 
 * @author pedro elias wiliam
 */
public class Boda extends Evento{
    private String vehiculo;
    final double precioBase =3500;
    final  String texto ="NO APLICA"; 
/**
 * constructor que recibe los sigts parametros y crea un objeto boda
 * @param tipo
 * @param fecha
 * @param codigo
 * @param cl
 * @param hInicio
 * @param hFin
 * @param capacidad
 * @param desicion
 * @param pl 
 */
   
    public Boda(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion, Planificador pl) {
        super(tipo, fecha, codigo, cl, hInicio, hFin, capacidad, desicion, pl);
    }


    /**
     * sobreescritura del metodo heredado 
     */

     public static void mostrarMensaje(){
        System.out.println("los novios tendran 25% de descuento si compran tickets de luna de miel en aerolinea Latam");
    }
}
