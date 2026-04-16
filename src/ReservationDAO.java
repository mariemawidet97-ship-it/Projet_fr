package dao;

import model.Reservation;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class ReservationDAO {

    public void ajouter(Reservation r) throws Exception {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO reservation(local_id, user_id, date) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, r.getLocalId());
        ps.setInt(2, r.getUserId());
        ps.setDate(3, new java.sql.Date(r.getDate().getTime()));

        ps.executeUpdate();
        System.out.println("Réservation ajoutée !");
    }

    public List<Reservation> getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        List<Reservation> list = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM reservation");

        while (rs.next()) {
            list.add(new Reservation(
                    rs.getInt("id"),
                    rs.getInt("local_id"),
                    rs.getInt("user_id"),
                    rs.getDate("date")
            ));
        }
        return list;
    }
}