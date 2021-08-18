/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author nguye
 */
public class Image {
    private int Id;
    private int GalleryId;
    private String path;

    public Image() {
    }

    public Image(int Id, int GalleryId, String path) {
        this.Id = Id;
        this.GalleryId = GalleryId;
        this.path = path;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getGalleryId() {
        return GalleryId;
    }

    public void setGalleryId(int GalleryId) {
        this.GalleryId = GalleryId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
    
}
