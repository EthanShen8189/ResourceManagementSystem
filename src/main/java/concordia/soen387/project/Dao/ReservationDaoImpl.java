package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by EthanShen on 2016-12-02.
 */
public class ReservationDaoImpl implements ReservationDao{

    private JdbcTemplate jdbcTemplate;

    public ReservationDaoImpl(){}

    public ReservationDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addReservation(Reservation Reservation) {

    }

    @Override
    public void updateReservation(Reservation Reservation) {

    }

    @Override
    public void deleteReservation(int ReservationId) {

    }

    @Override
    public Reservation getReservationById(int ReservationId) {
        return null;
    }

    @Override
    public Reservation getLastestReservation() {
        return null;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return null;
    }
}
