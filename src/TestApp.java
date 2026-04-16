import dao.LocalDAO;
import dao.ReservationDAO;
import model.Local;
import model.Reservation;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestApp {

    public static void main(String[] args) {

        try {
            LocalDAO localDAO = new LocalDAO();
            ReservationDAO reservationDAO = new ReservationDAO();


            Local l = new Local(0, "Salle A", 50);
            localDAO.ajouter(l);


            System.out.println("Liste des locaux :");
            List<Local> locaux = localDAO.getAll();
            for (Local loc : locaux) {
                System.out.println(loc);
            }

            Reservation r = new Reservation(
                    0,
                    1, // id local
                    1, // id user
                    new SimpleDateFormat("yyyy-MM-dd").parse("2026-04-20")
            );

            reservationDAO.ajouter(r);
            System.out.println(" Liste des réservations :");
            List<Reservation> reservations = reservationDAO.getAll();
            for (Reservation res : reservations) {
                System.out.println(res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}