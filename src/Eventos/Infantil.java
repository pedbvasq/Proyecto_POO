

package Eventos;

import Usuarios.Cliente;
import java.util.Date;


public class Infantil extends Evento{
    private int cantidadPersonajes;
    private int cantidadSorpresas;
    private String juegos;

    public Infantil(TipoEvento tipo, Date fecha, Cliente cl, Date hInicio, Date hFin) {
        super(tipo, fecha, cl, hInicio, hFin);
    }
    
    
    
}
