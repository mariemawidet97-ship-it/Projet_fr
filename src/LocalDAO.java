package dao;

import model.Local;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class LocalDAO {

    public void ajouter(Local l) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO local(nom, capacite) VALUES (?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, l.getNom());
        ps.setInt(2, l.getCapacite());
        ps.executeUpdate();

        System.out.println("Local ajouté !");
    }

    public List<Local> getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        List<Local> list = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM local");

        while (rs.next()) {
            list.add(new Local(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getInt("capacite")
            ));
        }
        return list;
    }
}