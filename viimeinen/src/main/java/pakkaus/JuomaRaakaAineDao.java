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


public class JuomaRaakaAineDao implements Dao<JuomaRaakaAine, Integer>{
    
    private Database database;

    public JuomaRaakaAineDao(Database database) {
        this.database = database;
    }
    
    @Override
    public JuomaRaakaAine findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JuomaRaakaAine> findAll() throws SQLException {
//    List lista = new ArrayList();
//        Connection conn = this.database.getConnection();
//        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM JuomaRaakaAine");
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            lista.add(new JuomaRaakaAine(rs.getInt("id"), rs.getString("nimi")));
//        }
//        stmt.close();
//        rs.close();
//        conn.close();
        return null;
    }

    
    public JuomaRaakaAine saveOrUpdate(JuomaRaakaAine object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}