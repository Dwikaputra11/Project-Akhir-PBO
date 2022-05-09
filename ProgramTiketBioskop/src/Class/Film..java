package Class;

import java.util.Date;

class Film{
    private String name;
    private String synopsis;
    private int code;
    private Date date;


    public Film(String name, String synopsis, int code, Date date) {
        this.name = name;
        this.synopsis = synopsis;
        this.code = code;
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

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Film name(String name) {
        setName(name);
        return this;
    }

    public Film synopsis(String synopsis) {
        setSynopsis(synopsis);
        return this;
    }

    public Film code(int code) {
        setCode(code);
        return this;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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