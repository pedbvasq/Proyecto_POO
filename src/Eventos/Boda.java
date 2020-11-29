
package Eventos;

import Usuarios.Cliente;
import java.util.Date;


public class Boda extends Evento{
    private String vehiculo;
    final  String texto ="NO APLICA"; 

    public Boda(TipoEvento tipo, Date fecha, Cliente cl, Date hInicio, Date hFin) {
        super(tipo, fecha, cl, hInicio, hFin);
    }
}
