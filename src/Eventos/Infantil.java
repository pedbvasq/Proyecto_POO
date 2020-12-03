

package Eventos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.Date;


public class Infantil extends Evento{
    private int cantidadPersonajes;
    private int cantidadSorpresas;
    private String juegos;
     final double precioBase =300;

    public Infantil(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion, Planificador pl) {
        super(tipo, fecha, codigo, cl, hInicio, hFin, capacidad, desicion, pl);
    }

    
    
    @Override
    public void mostrarMensaje(){
        
    }
    
    
}
