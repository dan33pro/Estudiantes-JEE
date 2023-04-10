/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiente.servlet;

import co.edu.unipiloto.estudiante.entity.Curso;
import co.edu.unipiloto.estudiante.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducar
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    
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
        
        String codCurso = request.getParameter("COD_Curso");
        String nomCurso = request.getParameter("Nombre");
        int creCurso;
        int semCurso;
        int admCurso;
        BigInteger precio;

        try {
            creCurso = Integer.parseInt(request.getParameter("Creditos"));
            semCurso = Integer.parseInt(request.getParameter("Semestre"));
            admCurso = Integer.parseInt(request.getParameter("N_Admitidos"));
            precio = new BigInteger(request.getParameter("P_Curso"));
        } catch (Exception e) {
            creCurso = -1;
            semCurso = -1;
            admCurso = -1;
            precio = new BigInteger("0");
        }

        Curso curso = new Curso(codCurso, nomCurso, creCurso, semCurso, admCurso,precio);
        
        String opcion = request.getParameter("action");
        switch (opcion) {
            case "Add":
                cursoFacade.create(curso);
                break;
            case "Edit":
                cursoFacade.edit(curso);
                break;
            case "Delete":
                cursoFacade.remove(curso);
                break;
            case "Search":
                if (!codCurso.equals("")) {
                    curso = cursoFacade.find(codCurso);
                }
                break;
        }
        
        request.setAttribute("curso", curso);
        request.setAttribute("allCurs", cursoFacade.findAll());
        request.getRequestDispatcher("cursoInfo.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CursoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CursoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
