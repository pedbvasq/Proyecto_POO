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
    final double precioBase = 2000;

    /**
     * constructor que recibe los sigts parametros y crea un objeto empresarial
     *
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
    
    public Empresarial(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion, Planificador pl) {
        super(tipo, fecha, codigo, cl, hInicio, hFin, capacidad, desicion, pl);
    }

    /**
     * metodo heradado ,genera un mensaje
     */
    public static void mostrarMensaje() {
        System.out.println("SI realizan un proximo evento, en un plazo de 6 meses el servicio "
                + "de transporte sera gratuito si lo realizan con el mismo planificador");
    }

    
}
