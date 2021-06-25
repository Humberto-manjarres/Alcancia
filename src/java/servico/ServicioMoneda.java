/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import maestros.Moneda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Objects.isNull;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maestros.Alcancia;
import repositorio.AlcanciaRepositorio;

/**
 *
 * @author Humberto Manjarres
 */
public class ServicioMoneda {

    Moneda monedas;
    List<Moneda> listaMonedas = new ArrayList<>();
    AlcanciaRepositorio alcanciaRepository = new AlcanciaRepositorio();

    public void agregarMoneda(HttpServletRequest request, HttpServletResponse response) {

        String moneda1 = request.getParameter("txtMoneda1");
        String moneda2 = request.getParameter("txtMoneda2");
        String moneda3 = request.getParameter("txtMoneda3");
        String moneda4 = request.getParameter("txtMoneda4");
        String moneda5 = request.getParameter("txtMoneda5");
        int cantidadMoneda = 0;
        Moneda moneda = null;
        
        /* alcanciaRepository va devolver un objeto alcancia estatico que se guarda en un objeto de tipo alcancia*/
        Alcancia alcancia = alcanciaRepository.getAlcancia();
        
        
        if (!isNull(moneda1) && !"".equals(moneda1)) {
            cantidadMoneda = Integer.parseInt(moneda1);
            for (int i = 0; i < cantidadMoneda; i++) {
                moneda = new Moneda();
                moneda.setValor(50);
                alcancia.setMoneda(moneda);
            }
        }

        if (!isNull(moneda2) && !"".equals(moneda2)) {
            cantidadMoneda = Integer.parseInt(moneda2);
            for (int i = 0; i < cantidadMoneda; i++) {
                moneda = new Moneda();
                moneda.setValor(100);
                alcancia.setMoneda(moneda);
            }
        }

        if (!isNull(moneda3) && !"".equals(moneda3)) {
            cantidadMoneda = Integer.parseInt(moneda3);
            for (int i = 0; i < cantidadMoneda; i++) {
                moneda = new Moneda();
                moneda.setValor(200);
                alcancia.setMoneda(moneda);
            }
        }

        if (!isNull(moneda4) && !"".equals(moneda4)) {
            cantidadMoneda = Integer.parseInt(moneda4);
            for (int i = 0; i < cantidadMoneda; i++) {
                moneda = new Moneda();
                moneda.setValor(500);
                alcancia.setMoneda(moneda);
            }
        }

        if (!isNull(moneda5) && !"".equals(moneda5)) {
            cantidadMoneda = Integer.parseInt(moneda5);
            for (int i = 0; i < cantidadMoneda; i++) {
                moneda = new Moneda();
                moneda.setValor(1000);
                alcancia.setMoneda(moneda);
            }
        }

        if(isNull(moneda)){
            request.setAttribute("mensaje", "Solo se reciben monedas de 50-100-200-500-1000");  
        }

        actualizarDatos(request);

    }

    private void actualizarDatos(HttpServletRequest request) {

        List<Moneda> monedas = alcanciaRepository.getAlcancia().getMonedas();
        //cantidad de monedas en general
        int cantidadMonedas = monedas.size();

        //valor total de monedas 
        int valorTotal = monedas.stream().collect(Collectors.summingInt(moneda -> moneda.getValor()));

        request.setAttribute("cantidad_monedas", cantidadMonedas);
        request.setAttribute("valor_total", valorTotal);

        //monedas de 50 
        int acuMoneda = monedas.stream().filter(moneda -> moneda.getValor() == 50).collect(Collectors.summingInt(Moneda::getValor));
        int acumCantidad = (int) monedas.stream().filter(moneda -> moneda.getValor() == 50).count();
        request.setAttribute("total_50", acuMoneda);
        request.setAttribute("cantidad_50", acumCantidad);

        acuMoneda = monedas.stream().filter(moneda -> moneda.getValor() == 100).collect(Collectors.summingInt(Moneda::getValor));
        acumCantidad = (int) monedas.stream().filter(moneda -> moneda.getValor() == 100).count();
        request.setAttribute("total_100", acuMoneda);
        request.setAttribute("cantidad_100", acumCantidad);

        acuMoneda = monedas.stream().filter(moneda -> moneda.getValor() == 200).collect(Collectors.summingInt(Moneda::getValor));
        acumCantidad = (int) monedas.stream().filter(moneda -> moneda.getValor() == 200).count();
        request.setAttribute("total_200", acuMoneda);
        request.setAttribute("cantidad_200", acumCantidad);

        acuMoneda = monedas.stream().filter(moneda -> moneda.getValor() == 500).collect(Collectors.summingInt(Moneda::getValor));
        acumCantidad = (int) monedas.stream().filter(moneda -> moneda.getValor() == 500).count();
        request.setAttribute("total_500", acuMoneda);
        request.setAttribute("cantidad_500", acumCantidad);

        acuMoneda = monedas.stream().filter(moneda -> moneda.getValor() == 1000).collect(Collectors.summingInt(Moneda::getValor));
        acumCantidad = (int) monedas.stream().filter(moneda -> moneda.getValor() == 1000).count();
        request.setAttribute("total_1000", acuMoneda);
        request.setAttribute("cantidad_1000", acumCantidad);

    }

    public void vaciarAlcancia() {
        alcanciaRepository.vaciarAlcancia();
    }


}
