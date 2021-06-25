/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maestros;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

/**
 *
 * @author Humberto Manjarres
 */
public class Alcancia {
    
    
    //lista donde solo guardamos objetos de tipo Moneda
    List<Moneda> monedas;

    /*singleton, si no existe un objeto o instancia de tipo List<Moneda>, crea una instancia,
        y si existe una instancia entonces retornará la lista.
    
        el método getMoneda es para saber las monedas agregadas a la lista
    */
    public List<Moneda> getMonedas() {
        /*por primera vez crea la instancia y retorna vacio 
        por segunda vez retornará con monedas*/
        if(isNull(monedas)){
            monedas=new ArrayList();
        }
        return monedas;
    }
    
    /*método setMoneda es para agregar monedas a la lista*/
    public void setMoneda(Moneda moneda){
       /*getMoneda para que retorne la lista y a dicha lista le agragamos la moneda
        que viene como parametro
        */
       //getMonedas().add(moneda);
        if(monedaValida(moneda)){
            getMonedas().add(moneda);
        }
    }

    private boolean monedaValida(Moneda moneda) {
        
        return moneda.getValor()==50 || moneda.getValor()==100 || moneda.getValor()==200
                || moneda.getValor()==500 || moneda.getValor()==1000;
    }
    
    
    
    
}
