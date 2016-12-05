package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.Reservation;
import concordia.soen387.project.Model.ReservationResources;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface ReservationResourceDao {
	
	void addReservationResource(ReservationResources reservationResources);
	void updateReservationResource(ReservationResources reservationResources);
	void deleteReservationResource(int reservationId, int resourceId);
	ReservationResources getReservationResourceById(int resourceId);
	List<ReservationResources> getAllReservationResources();
    List<Long> getAllreservationWithID(long l);
}
