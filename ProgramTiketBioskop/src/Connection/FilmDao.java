package Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Class.Film;

public class FilmDao {
    private Connector con = new Connector();
    public Film getFilm(int code){
        try{
            String query = "select * from movies where kode="+code;
            Film film = new Film();
            film.setCode(code);
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            rs.next();
            String name = rs.getString("nama");
            film.setName(name);
            String synopsis = rs.getString("sinopsis");
            film.setSynopsis(synopsis);
            String image = rs.getString("gambar");
            film.setImageUrl(image);
            return film;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;   
    } 
    public boolean addFilm(Film film){
        String query = "insert into movies value (?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(1, film.getName());
            pstm.setInt(2, film.getCode());
            pstm.setString(3, film.getSynopsis());
            pstm.setString(4, film.getImageUrl());
            pstm.executeUpdate();
            return true; 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public boolean deleteFilm(int code){
        String query = "delete from movies where code="+code;
        PreparedStatement pstm;
        try{
           pstm = con.koneksi.prepareStatement(query);
           pstm.executeQuery();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }
}
