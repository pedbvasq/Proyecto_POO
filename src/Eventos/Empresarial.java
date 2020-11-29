/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Usuarios.Cliente;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class Empresarial extends Evento {
    private int cantidadPersonas;

    public Empresarial(TipoEvento tipo, Date fecha, Cliente cl, Date hInicio, Date hFin) {
        super(tipo, fecha, cl, hInicio, hFin);
    }
    

    @Override
    public void mostrarMensaje() {

    }
}
