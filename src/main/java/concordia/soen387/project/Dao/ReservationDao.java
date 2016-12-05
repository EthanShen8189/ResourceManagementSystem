package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Reservation;

import java.util.List;

/**
 * Created by EthanShen on 2016-12-02.
 */
public interface ReservationDao {
    void addReservation(Reservation Reservation);
    void updateReservation(Reservation Reservation);
    void deleteReservation(int ReservationId);
    Reservation getReservationById(long ReservationId);
    List<Reservation> getAllReservation();
    Reservation getLastIndexReservation();
    List<Reservation> getAllreservationWithID(long l);
    List<Reservation> getAllReservationByUsername(String username);
}
