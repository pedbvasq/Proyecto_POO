
package Eventos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.Date;


public class Boda extends Evento{
    private String vehiculo;
    final double precioBase =3500;
    final  String texto ="NO APLICA"; 

    public Boda(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion, Planificador pl) {
        super(tipo, fecha, codigo, cl, hInicio, hFin, capacidad, desicion, pl);
    }

    
    @Override
     public void mostrarMensaje(){
        
    }
}
