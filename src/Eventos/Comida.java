/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Comida extends ElementoAdicional {

    private final int precioMenu = 15;
    //private double precioFinal;
    static Scanner sc = new Scanner(System.in);

    @Override
    public void establecerCantidad() {
        int cantidad;
        System.out.println("Cantidadn de platos:");
        cantidad = sc.nextInt();
        super.setCantidad(cantidad);
        this.setPrecioFinal(precioMenu * cantidad);
        

    }
    
}