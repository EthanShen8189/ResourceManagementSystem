package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.MyReservation;

import java.util.List;

/**
 * Created by EthanShen on 2016-12-05.
 */
public interface MyReservationDao {
    List<MyReservation> getAllMyReservation(String username);
}
