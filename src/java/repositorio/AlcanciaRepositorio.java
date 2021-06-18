/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import maestros.Alcancia;

/**
 *
 * @author amejia
 */
public class AlcanciaRepositorio {
    
    private static Alcancia alcancia=new Alcancia();
    
    
    public Alcancia getAlcancia(){
        return alcancia;
    }

    public void vaciarAlcancia() {
        alcancia.getMonedas().clear();
    }
    
    
    
    
    
}
