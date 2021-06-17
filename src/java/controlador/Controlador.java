/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.BreakNode;
import logica.LogicaMoneda;
import maestros.Monedas;

/**
 *
 * @author Humberto Manjarres
 */
public class Controlador extends HttpServlet {

    
    List<Monedas> listaMonedas = new ArrayList<>();
    LogicaMoneda logicaMoneda = new LogicaMoneda();
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int acumCantidad1 = 0, acumCantidad2 = 0, acumCantidad3 = 0, acumCantidad4 = 0, acumCantidad5 = 0;
        int acumValor1 = 0, acumValor2 = 0, acumValor3 = 0, acumValor4 = 0, acumValor5 = 0;
        String accion = request.getParameter("accion");

        if (accion.equals("Agregar")) {

            String moneda1 = request.getParameter("txtMoneda1");
            String moneda2 = request.getParameter("txtMoneda2");
            String moneda3 = request.getParameter("txtMoneda3");
            String moneda4 = request.getParameter("txtMoneda4");
            String moneda5 = request.getParameter("txtMoneda5");
            listaMonedas = logicaMoneda.getMoneda(moneda1, moneda2, moneda3, moneda4, moneda5);
            
            if (!listaMonedas.isEmpty()) {
                /* mantener la tabla con resultados de todas las monedas*/
                for (Monedas listaMoneda : listaMonedas) {
                    if (listaMoneda.getMoneda().equals("50")) {
                        acumCantidad1 = acumCantidad1 + listaMoneda.getCantidad();
                        acumValor1 = acumValor1 + listaMoneda.getValor();
                        request.setAttribute("total_50", acumValor1);
                        request.setAttribute("cantidad_50", acumCantidad1);
                    } else if (listaMoneda.getMoneda().equals("100")) {
                        acumCantidad2 = acumCantidad2 + listaMoneda.getCantidad();
                        acumValor2 = acumValor2 + listaMoneda.getValor();
                        request.setAttribute("total_100", acumValor2);
                        request.setAttribute("cantidad_100", acumCantidad2);
                    } else if (listaMoneda.getMoneda().equals("200")) {
                        acumCantidad3 = acumCantidad3 + listaMoneda.getCantidad();
                        acumValor3 = acumValor3 + listaMoneda.getValor();
                        request.setAttribute("total_200", acumValor3);
                        request.setAttribute("cantidad_200", acumCantidad3);
                    } else if (listaMoneda.getMoneda().equals("500")) {
                        acumCantidad4 = acumCantidad4 + listaMoneda.getCantidad();
                        acumValor4 = acumValor4 + listaMoneda.getValor();
                        request.setAttribute("total_500", acumValor4);
                        request.setAttribute("cantidad_500", acumCantidad4);
                    } else if (listaMoneda.getMoneda().equals("1000")) {
                        acumCantidad5 = acumCantidad5 + listaMoneda.getCantidad();
                        acumValor5 = acumValor5 + listaMoneda.getValor();
                        request.setAttribute("total_1000", acumValor5);
                        request.setAttribute("cantidad_1000", acumCantidad5);
                    }else{
                        request.setAttribute("mensaje", "Moneda no valida");
                    }
                }
                int cantidadMonedas = acumCantidad1 + acumCantidad2 + acumCantidad3 + acumCantidad4 + acumCantidad5;
                int valorTotal = acumValor1 + acumValor2 + acumValor3 + acumValor4 + acumValor5;

                request.setAttribute("cantidad_monedas", cantidadMonedas);
                request.setAttribute("valor_total", valorTotal);
            } else {
                request.setAttribute("mensaje", "Debe Insertar al menos una moneda!");
            }

        } else if (accion.equals("Limpiar")) {
            System.out.println("Limpiar");
            
        } else if (accion.equals("Vaciar Alcancia")) {
            listaMonedas.clear();
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
