/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiente.servlet;

import co.edu.unipiloto.estudiante.entity.Estudiante;
import co.edu.unipiloto.estudiante.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

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
        
        int id;
        int yearLevel;
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String yearStr = request.getParameter("yearLevel");
        try {
            id = Integer.parseInt(request.getParameter("estudianteId"));
        } catch (Exception e) {
            id = -1;
        }
        try {
            yearLevel = Integer.parseInt(yearStr);
        } catch (Exception e) {
            yearLevel = -1;
        }
        
        String action =  request.getParameter("action");
        System.out.println(action);

        Estudiante student = new Estudiante(id, firstName, lastName, yearLevel);
        switch (action){
            case "Edit":
                estudianteFacade.edit(student);
                break;
            case "Delete":
                estudianteFacade.remove(student);
                break;
            case "Add":
                estudianteFacade.create(student);
                break;
            case "Search":
                if (id != -1) {
                    student = estudianteFacade.find(id);
                } else {
                    student.setEstudianteId(null);
                    student.setYearLevel(null);
                }
                break;
        }


        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("student", student);
        request.setAttribute("allStudents", estudianteFacade.findAll());
        request.getRequestDispatcher("estudianteInfo.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudianteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EstudianteServlet at " + request.getContextPath() + "</h1>");
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
