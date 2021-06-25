/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import maestros.Alcancia;

/**
 *
 * @author Humberto Manjarres
 */
public class AlcanciaRepositorio {
    
    /* esta clase simula una conexion a la base de datos
        y la clase Alcancia simula la base de datos donde estarán los objetos monedas
    */
    //todo lo que almacene el objeto alcancia perdurará, en este caso el objeto alcancia tiene una lista como atributo
    private static Alcancia alcancia=new Alcancia();
    
    
    public Alcancia getAlcancia(){
        return alcancia;
    }

    public void vaciarAlcancia() {
        alcancia.getMonedas().clear();
    }
    
    
    
    
    
}
