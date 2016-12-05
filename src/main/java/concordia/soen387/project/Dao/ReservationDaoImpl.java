package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Reservation;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void addReservation(Reservation reservation) {
    	String sql = "INSERT INTO reservation (id,start_date_time,end_date_time, user_username)"
                 + "VALUE (?,?,?,?)";
    	jdbcTemplate.update(sql, reservation.getId(), reservation.getStart_date_time(),
    			reservation.getEnd_date_time(), reservation.getUser_username());
    }

    @Override
    public void updateReservation(Reservation reservation) {
    	if(!(reservation.getUser_username().equalsIgnoreCase(""))){
	    	String sql = "UPDATE reservation SET id=?, start_date_time=?, end_date_time=?, user_username=? "
	    			+ "WHERE id=? AND user_username=?";
	    	jdbcTemplate.update(sql, reservation.getId(), reservation.getStart_date_time(),
	    			reservation.getEnd_date_time(), reservation.getUser_username(), 
	    			reservation.getId(), reservation.getUser_username());
    	}
    }

    @Override
    public void deleteReservation(int reservationId) {
    	String sql = "DELETE FROM reservation WHERE id=?";
        jdbcTemplate.update(sql, reservationId);
    }

    @Override
    public Reservation getReservationById(long reservationId) {
    	String sql = "SELECT * FROM reservation WHERE id=" + reservationId;
    	return jdbcTemplate.query(sql, new ResultSetExtractor<Reservation>() {

			@Override
			public Reservation extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if(resultSet.next()){
					return initReservation(resultSet);
				}
				return null;
			}
    		
    	});
    	
    }

    @Override
    public List<Reservation> getAllReservation() {
        String sql = "SELECT * FROM reservation";
        List<Reservation> reservationList = jdbcTemplate.query(sql, new RowMapper<Reservation>(){

			@Override
			public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
				return initReservation(resultSet);
			}
        	
        });
        return reservationList;
    }

    @Override
    public Reservation getLastIndexReservation() {
        String sql = "SELECT * FROM reservation where id = (select max(id) from reservation)";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Reservation>() {
            @Override
            public Reservation extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initReservation(resultSet);
                }
                return null;
            }
        });
    }

    @Override
    public List<Reservation> getAllreservationWithID(long l) {
        String sql = "SELECT * FROM reservation WHERE id=" + l;
        List<Reservation> reservationList = jdbcTemplate.query(sql, new RowMapper<Reservation>(){

            @Override
            public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
                return initReservation(resultSet);
            }

        });
        return reservationList;
    }

    @Override
    public List<Reservation> getAllReservationByUsername(String username) {
        String sql = "SELECT * FROM reservation WHERE id=" + "\'"+username+"\'";
        List<Reservation> reservationList = jdbcTemplate.query(sql, new RowMapper<Reservation>(){

            @Override
            public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
                return initReservation(resultSet);
            }

        });
        return reservationList;
    }

    private Reservation initReservation(ResultSet resultSet) throws SQLException{
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt("id"));
        reservation.setStart_date_time(resultSet.getString("start_date_time"));
        reservation.setEnd_date_time(resultSet.getString("end_date_time"));
        reservation.setUser_username(resultSet.getString("user_username"));

        return reservation;
    }
}
