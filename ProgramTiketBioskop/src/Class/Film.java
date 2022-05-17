package Class;

<<<<<<< HEAD

=======
>>>>>>> eb370eeab5a20bc889ff3f785f04e137c61a9133
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

    public Film(String name, String date){
        this.name = name;
        this.date = date;
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
}