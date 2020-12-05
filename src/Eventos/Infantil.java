

package Eventos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.Date;

/**
 * 
 * @author pedro
 */
public class Infantil extends Evento{
    private int cantidadPersonajes;
    private int cantidadSorpresas;
    private String juegos;
    final double precioBase =300;
/**
 * construcor que genera  un objeto infantil con los parametros indicados
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
    public Infantil(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion, Planificador pl) {
        super(tipo, fecha, codigo, cl, hInicio, hFin, capacidad, desicion, pl);
    }

 /**
  * metodo heredado , genera un mensaje
  */   
    
 

    
    public static void mostrarMensaje() {
        System.out.println("SI realizan un proximo evento, en un plazo de 6 meses se les otorgara un servicio de msuica gratuito");
    }
    
    
}
