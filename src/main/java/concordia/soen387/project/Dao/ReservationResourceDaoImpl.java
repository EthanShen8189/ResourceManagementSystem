package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.ReservationResources;

/**
 * Created by Van Do on 2016-12-03.
 */
public class ReservationResourceDaoImpl implements ReservationResourceDao{

	
	private JdbcTemplate jdbcTemplate;
	
	public ReservationResourceDaoImpl(){}
	public ReservationResourceDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void addReservationResource(ReservationResources reservationResources) {
		String sql = "INSERT INTO reservation_resources (reservation_id, resources_id) VALUE (?,?)";
		 jdbcTemplate.update(sql, reservationResources.getReservation_id(), reservationResources.getResource_id());
		
	}

	@Override
	public void updateReservationResource(ReservationResources reservationResources) {
		if(!(reservationResources.getResource_id() < 0 && reservationResources.getReservation_id() < 0)){
			String sql = "UPDATE reservation_resources SET reservation_id=?, resources_id=? WHERE reservation_id=? AND resources_id=?";
			jdbcTemplate.update(sql, reservationResources.getReservation_id(), reservationResources.getResource_id(), 
					reservationResources.getReservation_id(), reservationResources.getResource_id());
		}
		
	}

	@Override
	public void deleteReservationResource(int reservationId, int resourceId) {
		String sql = "DELETE FROM reservation_resources WHERE reservation_id=? AND resources_id=? ";
	     jdbcTemplate.update(sql, reservationId, resourceId);
		
	}

	@Override
	public ReservationResources getReservationResourceById(int resourceId) {
		String sql = "SELECT * FROM reservation_resources WHERE id=" + resourceId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<ReservationResources>() {
            @Override
            public ReservationResources extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initReservationResources(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<ReservationResources> getAllReservationResources() {
		String sql = "SELECT * FROM reservation_resources";
        List<ReservationResources> reservationResourceList = jdbcTemplate.query(sql, new RowMapper<ReservationResources>() {
            @Override
            public ReservationResources mapRow(ResultSet resultSet, int i) throws SQLException {
                return initReservationResources(resultSet);
            }
        });

        return reservationResourceList;
	}

	@Override
	public List<Long> getAllreservationWithID(long l) {
		String sql = "SELECT * FROM reservation_resources WHERE resources_id=" + l;
		List<ReservationResources> reservationResourceList = jdbcTemplate.query(sql, new RowMapper<ReservationResources>() {
			@Override
			public ReservationResources mapRow(ResultSet resultSet, int i) throws SQLException {
				return initReservationResources(resultSet);
			}
		});

		List<Long> reservationIDList = new ArrayList<>();
		for(ReservationResources reservationResources: reservationResourceList){
			reservationIDList.add((long) reservationResources.getReservation_id());
		}
		return reservationIDList;
	}

	private ReservationResources initReservationResources(ResultSet resultSet) throws SQLException{
		ReservationResources reservationResources = new ReservationResources();
		reservationResources.setReservation_id(resultSet.getInt("reservation_id"));
		reservationResources.setResource_id(resultSet.getInt("resources_id"));
		return reservationResources;
	}


}
