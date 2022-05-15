package Class;

import java.util.ArrayList;
import java.util.Arrays;

public class Film{
    private String code;
    private String name;
    private String synopsis;
    private String date;
    private String imageUrl;


    public Film(String code,String name, String synopsis, String date, String imageUrl) {
        this.name = name;
        this.synopsis = synopsis;
        this.code = code;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    
    public Film() {
    }

    public Film(String code, String name, String synopsis, String imageUrl){
        this.code = code;
        this.name = name;
        this.synopsis = synopsis;
        this.imageUrl = imageUrl;
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
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
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
//   public ArrayList<Film> filmList = new ArrayList<Film>(
    //     Arrays.asList(
    //         new Film("","Doctor Strange","Bla bla bla", "12 April 2021","img/20220"),
    //         new Film("","KKN Penari","Bla bla bla", "13 April 2021","img/20220"),
    //         new Film("","Doctor Strange","Bla bla bla", "14 April 2021","img/20220"),
    //         new Film("","Doctor Strange","Bla bla bla", "15 April 2021","img/20220")
    //     )
    // );
    // 
}