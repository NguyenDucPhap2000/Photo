/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.DBContext;
import Entity.Contact;
import Entity.Gallery;
import Entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class DaoGallery {
    
    public int getTotalGallery() throws Exception {
        DBContext db = new DBContext();
        //Connect to sql server
        Connection cnn = null;
        //move sql Statement to sql server and excute
        PreparedStatement ps = null;
        // get result
        ResultSet rs = null;
        int result = 0;
        try {
            String sql = "select COUNT(*) from Gallery";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            //take data from sql to netbean
            while (rs.next()) {
                result = rs.getInt(1);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
        return 0;
    }
    
    public List<Gallery> paging(int indexPage, int paging) throws Exception {
        DBContext db = new DBContext();
        //opening connect to sql server
        Connection cnn = null;
        // give statement to sql server
        PreparedStatement ps = null;
        // get result from sql server to netbean
        ResultSet rs = null;
        try {
            String sql = "select * from\n"
                    + "(select ROW_NUMBER() over(order by id asc) as num,* from Gallery) as r \n"
                    + "where r.num between ? * ? - 2 and ? * ?";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, indexPage);
            ps.setInt(2, paging);
            ps.setInt(3, indexPage);
            ps.setInt(4, paging);
            rs = ps.executeQuery();
            List<Gallery> list = new ArrayList<>();
            // take data from result received from sql server
            while (rs.next()) {
                Gallery ga = new Gallery(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("name")
                );
                list.add(ga);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
    
    public String getimagePath(int id) throws Exception {
        DBContext db = new DBContext();
        //opening connect to sql server
        Connection cnn = null;
        // give statement to sql server
        PreparedStatement ps = null;
        // get result from sql server to netbean
        ResultSet rs = null;
        String path = "";
        try {
            String sql = "select top 1 * from Images where gallery_id = ?";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                path = rs.getString("image_url");
            }
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
    
    public List<Contact> getInfor() throws Exception {
        DBContext db = new DBContext();
        //opening connect to sql server
        Connection cnn = null;
        // give statement to sql server
        PreparedStatement ps = null;
        // get result from sql server to netbean
        ResultSet rs = null;
        List<Contact> list = new ArrayList<>();
        try {
            String sql = "select * from Contact";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact c = new Contact(
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("country"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getString("face_url"),
                        rs.getString("twitter_url"),
                        rs.getString("google_url"),
                        rs.getString("about"),
                        rs.getString("image_main"),
                        rs.getString("map"),
                        rs.getString("content_main")
                );
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
    
    public List<Gallery> getTop3Heder() throws Exception {
        DBContext db = new DBContext();
        //opening connect to sql server
        Connection cnn = null;
        // give statement to sql server
        PreparedStatement ps = null;
        // get result from sql server to netbean
        ResultSet rs = null;
        List<Gallery> list = new ArrayList<>();
        try {
            String sql = "select top 3* from Gallery";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery ga = new Gallery(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("name")
                );
                list.add(ga);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
    
    public int getTotalImage(int id) throws Exception {
        DBContext db = new DBContext();
        //opening connect to sql server
        Connection cnn = null;
        // give statement to sql server
        PreparedStatement ps = null;
        // get result from sql server to netbean
        ResultSet rs = null;
        try {
            String sql = "select COUNT(*) from Images where gallery_id = ?";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int result = 0;
            while (rs.next()) {
                result = rs.getInt(1);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
    
    public List<Image> getListImageGallery(int galleryId, int index, int paging) throws Exception {
        DBContext db = new DBContext();
        //opening connect to sql server
        Connection cnn = null;
        // give statement to sql server
        PreparedStatement ps = null;
        // get result from sql server to netbean
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            String sql = "select * from \n"
                    + "(select ROW_NUMBER() over(order by id asc) as r, * from Images where gallery_id=?) as x\n"
                    + "where x.r between ?*?-7 and ?*? and gallery_id = ?";
            cnn = db.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, galleryId);
            ps.setInt(2, index);
            ps.setInt(3, paging);
            ps.setInt(4, index);
            ps.setInt(5, paging);
            ps.setInt(6, galleryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Image img = new Image(
                        rs.getInt("id"),
                        rs.getInt("gallery_id"),
                        rs.getString("image_url")
                );
                list.add(img);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
}
