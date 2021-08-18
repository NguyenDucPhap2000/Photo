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
public class Contact {

    private String Address;
    private String City;
    private String County;
    private String Telephone;
    private String Email;
    private String Face;
    private String Twitter;
    private String Google;
    private String About;
    private String image_Main;
    private String Map;
    private String content_Main;

    public Contact() {
    }

    public Contact(String Address, String City, String County, String Telephone, String Email, String Face, String Twitter, String Google, String About, String image_Main, String Map, String content_Main) {
        this.Address = Address;
        this.City = City;
        this.County = County;
        this.Telephone = Telephone;
        this.Email = Email;
        this.Face = Face;
        this.Twitter = Twitter;
        this.Google = Google;
        this.About = About;
        this.image_Main = image_Main;
        this.Map = Map;
        this.content_Main = content_Main;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFace() {
        return Face;
    }

    public void setFace(String Face) {
        this.Face = Face;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String Twitter) {
        this.Twitter = Twitter;
    }

    public String getGoogle() {
        return Google;
    }

    public void setGoogle(String Google) {
        this.Google = Google;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String About) {
        this.About = About;
    }

    public String getImage_Main() {
        return image_Main;
    }

    public void setImage_Main(String image_Main) {
        this.image_Main = image_Main;
    }

    public String getMap() {
        return Map;
    }

    public void setMap(String Map) {
        this.Map = Map;
    }

    public String getContent_Main() {
        return content_Main;
    }

    public void setContent_Main(String content_Main) {
        this.content_Main = content_Main;
    }

}
