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
import logica.Monedas;

/**
 *
 * @author Humberto Manjarres
 */
public class Controlador extends HttpServlet {

    Monedas monedas;
    List<Monedas> listaMonedas = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int acumCant = 0, acumMonto = 0;
        int acumCantidad1 = 0, acumCantidad2 = 0, acumCantidad3 = 0, acumCantidad4 = 0, acumCantidad5 = 0;
        int acumValor1 = 0, acumValor2 = 0, acumValor3 = 0, acumValor4 = 0, acumValor5 = 0;
        int totalCantidad = 0, totalValor = 0;
        String accion = request.getParameter("accion");
        if (!listaMonedas.isEmpty()) {
            /* mantener la tabla con resultados de todas las monedas*/
            for (Monedas listaMoneda : listaMonedas) {
                if (listaMoneda.getMoneda().equals("50")) {
                    acumCantidad1 = acumCantidad1 + listaMoneda.getCantidad();
                    acumValor1 = acumValor1 + listaMoneda.getValor();
                } else if (listaMoneda.getMoneda().equals("100")) {
                    acumCantidad2 = acumCantidad2 + listaMoneda.getCantidad();
                    acumValor2 = acumValor2 + listaMoneda.getValor();
                } else if (listaMoneda.getMoneda().equals("200")) {
                    acumCantidad3 = acumCantidad3 + listaMoneda.getCantidad();
                    acumValor3 = acumValor3 + listaMoneda.getValor();
                } else if (listaMoneda.getMoneda().equals("500")) {
                    acumCantidad4 = acumCantidad4 + listaMoneda.getCantidad();
                    acumValor4 = acumValor4 + listaMoneda.getValor();
                } else if (listaMoneda.getMoneda().equals("1000")) {
                    acumCantidad5 = acumCantidad5 + listaMoneda.getCantidad();
                    acumValor5 = acumValor5 + listaMoneda.getValor();
                }
            }
        }else{
            
        }

        if (accion.equals("Agregar")) {
            listaMonedas.clear();
            if (!request.getParameter("txtMoneda1").equals("")) {
                int moneda1 = Integer.parseInt(request.getParameter("txtMoneda1"));
                monedas = new Monedas();
                monedas.setMoneda("50");
                monedas.setCantidad(moneda1 + acumCantidad1);
                monedas.setValor((moneda1 * 50) + acumValor1);
                listaMonedas.add(monedas);
            } else {
                monedas = new Monedas();
                monedas.setMoneda("50");
                monedas.setCantidad(acumCantidad1);
                monedas.setValor(acumValor1);
                listaMonedas.add(monedas);
            }

            if (!request.getParameter("txtMoneda2").equals("")) {
                int moneda2 = Integer.parseInt(request.getParameter("txtMoneda2"));
                monedas = new Monedas();
                monedas.setMoneda("100");
                monedas.setCantidad(moneda2 + acumCantidad2);
                monedas.setValor((moneda2 * 100) + acumValor2);
                listaMonedas.add(monedas);
            } else {
                monedas = new Monedas();
                monedas.setMoneda("100");
                monedas.setCantidad(acumCantidad2);
                monedas.setValor(acumValor2);
                listaMonedas.add(monedas);
            }

            if (!request.getParameter("txtMoneda3").equals("")) {
                int moneda3 = Integer.parseInt(request.getParameter("txtMoneda3"));
                monedas = new Monedas();
                monedas.setMoneda("200");
                monedas.setCantidad(moneda3 + acumCantidad3);
                monedas.setValor((moneda3 * 200) + acumValor3);
                listaMonedas.add(monedas);
            } else {
                monedas = new Monedas();
                monedas.setMoneda("200");
                monedas.setCantidad(acumCantidad3);
                monedas.setValor(acumValor3);
                listaMonedas.add(monedas);
            }

            if (!request.getParameter("txtMoneda4").equals("")) {
                int moneda4 = Integer.parseInt(request.getParameter("txtMoneda4"));
                monedas = new Monedas();
                monedas.setMoneda("500");
                monedas.setCantidad(moneda4 + acumCantidad4);
                monedas.setValor((moneda4 * 500) + acumValor4);
                listaMonedas.add(monedas);
            } else {
                monedas = new Monedas();
                monedas.setMoneda("500");
                monedas.setCantidad(acumCantidad4);
                monedas.setValor(acumValor4);
                listaMonedas.add(monedas);
            }

            if (!request.getParameter("txtMoneda5").equals("")) {
                int moneda5 = Integer.parseInt(request.getParameter("txtMoneda5"));
                monedas = new Monedas();
                monedas.setMoneda("1000");
                monedas.setCantidad(moneda5 + acumCantidad5);
                monedas.setValor((moneda5 * 1000) + acumValor5);
                listaMonedas.add(monedas);
            } else {
                monedas = new Monedas();
                monedas.setMoneda("1000");
                monedas.setCantidad(acumCantidad5);
                monedas.setValor(acumValor5);
                listaMonedas.add(monedas);
            }
            request.setAttribute("lista_monedas", listaMonedas);

            for (Monedas listaMoneda : listaMonedas) {
                acumCant = acumCant + listaMoneda.getCantidad();
                acumMonto = acumMonto + listaMoneda.getValor();
            }
            request.setAttribute("totalCantidad", acumCant);
            request.setAttribute("totalValor", acumMonto);

        } else if (accion.equals("Limpiar")) {
            System.out.println("Limpiar");
            request.setAttribute("lista_monedas", listaMonedas);
            request.setAttribute("totalCantidad", acumCant);
            request.setAttribute("totalValor", acumMonto);
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
