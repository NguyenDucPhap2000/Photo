/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Context.DBContext;
import Dao.DaoGallery;
import Entity.Gallery;
import Entity.Image;
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
public class GalleryControl extends HttpServlet {

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
            //Get header title Gallery 1 ,2 ,3
            List<Gallery> top3ga = dao.getTop3Heder();
            request.setAttribute("listgallery", top3ga);
            //get image path from file config
            DBContext db = new DBContext();
            String image = db.getImagePath();
            String index = "";
            // check program have key is index ?
            if (!request.getParameterMap().containsKey("index")) {
                index = "1";
            } else {
                index = request.getParameter("index");
            }
            int indexPage = 0;
            try {
                indexPage = Integer.parseInt(index);
            } catch (Exception e) {
                request.setAttribute("NotFound", "NotFound");
                request.getRequestDispatcher("Gallery.jsp").forward(request, response);
                return;
            }

            String name = "";
            // check program have key is name ?
            if (!request.getParameterMap().containsKey("name")) {
                name = "Gallery 1";
            } else {
                name = request.getParameter("name");
            }

            String idjsp = "";
            // check program have key is id ?
            if (!request.getParameterMap().containsKey("id")) {
                idjsp = "1";
            } else {
                //id get from Home and header firstly and after get from gallery.jsp
                idjsp = request.getParameter("id");
            }

            int galleryId = 0;
            try {
                galleryId = Integer.parseInt(idjsp);
            } catch (Exception e) {
                request.setAttribute("NotFound", "NotFound");
                request.getRequestDispatcher("Gallery.jsp").forward(request, response);
                return;
            }

            // count how many image if id = 1,2,3....
            int count = dao.getTotalImage(galleryId);
            int paging = 8;
            int endpage = count / paging;
            if (endpage % paging != 0) {
                endpage++;
            }
            //Get image path from sql server and up to jsp
            String mainImage = dao.getimagePath(galleryId);

            //Get image from sql server follow id
            List<Image> listImage = dao.getListImageGallery(galleryId, indexPage, paging);
            /*save galleryId to jsp and get galleryId again from jsp
            if dont have id will be null when you click page 2 >*/
            request.setAttribute("gallerId", idjsp);

            request.setAttribute("image", image);
            request.setAttribute("mainImage", mainImage);
            request.setAttribute("listImg", listImage);
            // up index to jsp in order to know which page clicked
            request.setAttribute("index", indexPage);
            request.setAttribute("nameGallery", name);
            request.setAttribute("endpage", endpage);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Error", "Error GalleryPage");
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
