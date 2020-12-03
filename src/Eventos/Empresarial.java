/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class Empresarial extends Evento {
    private int cantidadPersonas;
     final double precioBase =2000;

    public Empresarial(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion, Planificador pl) {
        super(tipo, fecha, codigo, cl, hInicio, hFin, capacidad, desicion, pl);
    }

   
    

    @Override
    public void mostrarMensaje() {

    }
}
