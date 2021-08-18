/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Context.DBContext;
import Dao.DaoGallery;
import Entity.Contact;
import Entity.Gallery;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */

public class HomeControl extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // get path img from dbcontext
            DBContext db = new DBContext();
            String imagePath = db.getImagePath();
            request.setAttribute("image", imagePath);
            // paging each page 3 news
            DaoGallery dao = new DaoGallery();
            int count = dao.getTotalGallery();

            int paging = 3;
            int endPage = (count / paging);
            if (count % paging != 0) {
                endPage++;
            }

            String index;
            //Do the path check "index" ?
            // key value => key value index = 1
            // map trong java
            if (request.getParameterMap().containsKey("index")) {
                index = request.getParameter("index");
            } else {
                index = "1";
            }
            int id = 0;
            // convert index to int and catch case: user fix path
            try {
                id = Integer.parseInt(index);
            } catch (Exception e) {
                request.setAttribute("error", "NOT FOUND");
            }
            if (id > endPage) {
                request.setAttribute("error", "NOT FOUND");
            }

            //Paging list view gallery
            List<Gallery> listga = dao.paging(id, paging);
            //load about me to Home
            List<Contact> listcon = dao.getInfor();
            // set data to right page and home page
            for (Contact c : listcon) {
                request.setAttribute("imageHome", c.getImage_Main());
                request.setAttribute("about", c.getAbout());
                request.setAttribute("imagetitle", c.getContent_Main());
                request.setAttribute("facebook", c.getFace());
                request.setAttribute("twitter", c.getTwitter());
                request.setAttribute("google", c.getGoogle());
            }
            //get top 3 header gallery
            List<Gallery> top3ga = dao.getTop3Heder();

            request.setAttribute("listgallery", top3ga);
            request.setAttribute("index", id);
            request.setAttribute("gallery", listga);
            request.setAttribute("endpage", endPage);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Error", "Error HomePage");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            throw e;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HomeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HomeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
