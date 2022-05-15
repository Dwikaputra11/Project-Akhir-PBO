package Class;

import java.util.ArrayList;
import java.util.Arrays;

public class Film{
    private String name;
    private String synopsis;
    private int code;
    private String date;
    private String imageUrl;


    public Film(int code,String name, String synopsis, String date, String imageUrl) {
        this.name = name;
        this.synopsis = synopsis;
        this.code = code;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    
    public Film() {
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSynopsis() {
        return this.synopsis;
    }
    
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", synopsis='" + getSynopsis() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
  
    public ArrayList<Film> filmList = new ArrayList<Film>(
        Arrays.asList(
            new Film(001,"Doctor Strange","Bla bla bla", "12 April 2021","img/20220"),
            new Film(002,"KKN Penari","Bla bla bla", "13 April 2021","img/20220"),
            new Film(003,"Doctor Strange","Bla bla bla", "14 April 2021","img/20220"),
            new Film(004,"Doctor Strange","Bla bla bla", "15 April 2021","img/20220")
        )
    );
}