package Class;

import java.util.Date;

public class Film{
    private String name;
    private String synopsis;
    private int code;
    private Date date;
    private String imageUrl;


    public Film(String name, String synopsis, int code, Date date, String imageUrl) {
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
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
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
    

    
}