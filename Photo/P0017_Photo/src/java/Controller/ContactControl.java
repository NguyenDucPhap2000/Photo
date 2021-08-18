/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoGallery;
import Entity.Contact;
import Entity.Gallery;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class ContactControl extends HttpServlet {

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
        try {
            DaoGallery dao = new DaoGallery();
            List<Contact> listCon = dao.getInfor();
            for (Contact c : listCon) {
                request.setAttribute("phone", c.getTelephone());
                request.setAttribute("email", c.getEmail());
                request.setAttribute("map", c.getMap());
                request.setAttribute("address", c.getAddress());
                request.setAttribute("city", c.getCity());
                request.setAttribute("country", c.getCounty());
                request.setAttribute("facebook", c.getFace());
                request.setAttribute("twitter", c.getTwitter());
                request.setAttribute("google", c.getGoogle());
            }
            //get top 3 header gallery
            List<Gallery> top3ga = dao.getTop3Heder();

            request.setAttribute("listgallery", top3ga);
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Error", "Error ContactPage");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
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
