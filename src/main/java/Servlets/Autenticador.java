/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EnterpriseJavaBeans.AuthenticationBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Henrique Linhares , Bruno Oliveira, Raphael Quintanilha
 */
@WebServlet(name = "Autenticador", urlPatterns = {"/Autenticador"})
public class Autenticador extends HttpServlet {

    @EJB
    AuthenticationBean authBean;

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
        try (PrintWriter out = response.getWriter()) {
            String tipoDeUsuario = (request.getParameter("select"));
            String login = (request.getParameter("login"));
            String senha = (request.getParameter("senha"));
            RequestDispatcher requestDispatcher = null;
            if (authBean.autentica(tipoDeUsuario, login, senha)) {

                request.getSession().setAttribute("loginUsuario", login);
                request.getSession().setAttribute("senhaUsuario", senha);
                request.getSession().setAttribute("tipoDeUsuario", tipoDeUsuario);

                if (tipoDeUsuario.equalsIgnoreCase("GerenteDeRecursos")) {
                    requestDispatcher = request.getRequestDispatcher("/GerenteDeRecursos/gerenteDeRecursoLogado.jsp");
                }

                if (tipoDeUsuario.equalsIgnoreCase("Professor")) {
                    requestDispatcher = request.getRequestDispatcher("Professor/professorLogado.jsp");
                }

                if (tipoDeUsuario.equalsIgnoreCase("AssistenteDeRecursos")) {
                    requestDispatcher = request.getRequestDispatcher("/AssistenteDeRecursos/assistenteDeRecursosLogado.jsp");
                }

            } else {
                requestDispatcher = request.getRequestDispatcher("loginMalsucedido.jsp");
            }
            requestDispatcher.forward(request, response);

        }
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
