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
 * @author amejia
 */
public class Alcancia {
    
    List<Moneda> monedas;

    //
    public List<Moneda> getMonedas() {
        
        if(isNull(monedas)){
            monedas=new ArrayList();
        }
        return monedas;
    }
    
    
    public void setMoneda(Moneda moneda){
        getMonedas().add(moneda);
    }
    
    
    
    
}
