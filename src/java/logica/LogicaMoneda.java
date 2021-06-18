/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import maestros.Monedas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Humberto Manjarres
 */
public class LogicaMoneda {

    Monedas monedas;
    List<Monedas> listaMonedas = new ArrayList<>();
    
    
    
    public List<Monedas> getMoneda(String moneda50, String moneda100, String moneda200, String moneda500, String moneda1000) {

        //listaMonedas.clear();
        
        /* control de monedas 50*/
        if (!moneda50.equals("")) {
            int moneda1 = Integer.parseInt(moneda50);
            monedas = new Monedas();
            monedas.setMoneda("50");
            monedas.setCantidad(moneda1);
            monedas.setValor((moneda1 * 50));
            listaMonedas.add(monedas);
        }

        /* control moneda 100*/
        if (!moneda100.equals("")) {
            int moneda2 = Integer.parseInt(moneda100);
            monedas = new Monedas();
            monedas.setMoneda("100");
            monedas.setCantidad(moneda2);
            monedas.setValor((moneda2 * 100));
            listaMonedas.add(monedas);
        }

        /* control monedas 200*/
        if (!moneda200.equals("")) {
            int moneda3 = Integer.parseInt(moneda200);
            monedas = new Monedas();
            monedas.setMoneda("200");
            monedas.setCantidad(moneda3 );
            monedas.setValor((moneda3 * 200));
            listaMonedas.add(monedas);
        } 

        /* control moneda 500*/
        if (!moneda500.equals("")) {
            int moneda4 = Integer.parseInt(moneda500);
            monedas = new Monedas();
            monedas.setMoneda("500");
            monedas.setCantidad(moneda4 );
            monedas.setValor((moneda4 * 500));
            listaMonedas.add(monedas);
        }

        /*control moneda 1000*/
        if (!moneda1000.equals("")) {
            int moneda5 = Integer.parseInt(moneda1000);
            monedas = new Monedas();
            monedas.setMoneda("1000");
            monedas.setCantidad(moneda5 );
            monedas.setValor((moneda5 * 1000));
            listaMonedas.add(monedas);
        } 
        
        return listaMonedas;

    }

}
