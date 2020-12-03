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
public class Bocaditos extends ElementoAdicional {

    private final double precioBocaditos = 0.25;
    private final double preciosPromociones = 0.10;
    static Scanner sc = new Scanner(System.in);

    @Override
    public double establecerCantidad() {
        int cantidad;
        System.out.println("Cuantos bocaditos desea");
        cantidad = sc.nextInt();
        super.setCantidad(cantidad);
        if (cantidad > 150) {
            return precioBocaditos * cantidad;

        } else {
            return preciosPromociones * cantidad;
        }

    }

}
