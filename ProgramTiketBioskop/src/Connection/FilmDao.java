package Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Class.Film;

public class FilmDao {
    private Connector con = new Connector();
    public Film getFilm(String code){
        System.out.println("getFilm()");
        try{
            String query = "select * from movies";
            Film film = new Film();
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                if(rs.getString("kode").equals(code)){
                    film.setCode(code);
                    film.setName(rs.getString("nama"));
                    film.setSynopsis(rs.getString("sinopsis"));
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;   
    }
    public boolean isFilmAdded(String code){
        System.out.println("SelectFilm()");
        try{
            String query = "select * from movies";
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                if(rs.getString("kode").equals(code)) return true; 
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    } 
    public void addFilm(Film film){
        System.out.println("addFilm()");
        String query = "insert into users(kode,nama,sinopsis) values (?,?,?)";
        PreparedStatement pstm;
        try {
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(0, film.getCode());
            pstm.setString(1, film.getName());
            pstm.setString(2, film.getSynopsis());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean deleteFilm(int code){
        System.out.println("deleteFilm()");
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
