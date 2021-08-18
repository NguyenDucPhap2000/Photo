/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Dao.DaoGallery;

/**
 *
 * @author nguye
 */
public class Gallery {

    private int id;
    private String title;
    private String desc;
    private String name;
    private String imagePath;

    public Gallery() {
    }

    public Gallery(int id, String title, String desc, String name, String imagePath) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.name = name;
        this.imagePath = imagePath;
    }

    public Gallery(int id, String title, String desc, String name) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.name = name;
    }

    public String getImagePath() throws Exception {
        DaoGallery dao = new DaoGallery();
        return dao.getimagePath(id);
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
