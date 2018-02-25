/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakkaus;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JuomaDao implements Dao<Juoma, Integer>{
    private Database db;
    public JuomaDao(Database db) {
        this.db = db;
        
    }
    
    @Override
    public Juoma findOne(Integer key) throws SQLException {
    Connection conn = this.db.getConnection();
        System.out.println("sdf");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Juoma WHERE id = ?");
        stmt.setObject(1, key);
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        Juoma uusi = new Juoma(rs.getInt("id"), rs.getString("nimi"), rs.getString("valmistusOhje"));
        stmt.close();
        rs.close();
        conn.close();
        return uusi; 
    }
    
    public int vapaaId() throws SQLException {
        return findAll().size()+1;
    }

    @Override
    public List<Juoma> findAll() throws SQLException {
    List lista = new ArrayList();
        Connection conn = this.db.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Juoma");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new Juoma(rs.getInt("id"), rs.getString("nimi"), rs.getString("valmistusOhje")));
        }
        stmt.close();
        rs.close();
        conn.close();
        return lista;
    }

    public List getAinekset(List listaaaa) {
        List lista = new ArrayList();
        
        return lista;
    }
    
    public Juoma saveOrUpdate(Juoma object) throws SQLException {
    Connection conn = this.db.getConnection();
    int iid = vapaaId();
        PreparedStatement stmt
                = conn.prepareStatement("INSERT INTO Juoma (id, nimi,valmistusohje) VALUES (?,?,?)");
        stmt.setInt(1, object.getId());
        stmt.setString(2, object.getNimi());
        stmt.setString(3, object.getValmistusOhje());
        stmt.executeUpdate();
        Juoma palautus = findOne(object.getId());
        conn.close();
        return palautus;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}