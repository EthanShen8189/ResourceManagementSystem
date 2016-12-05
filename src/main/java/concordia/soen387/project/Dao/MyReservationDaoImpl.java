package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.MyReservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by EthanShen on 2016-12-05.
 */
public class MyReservationDaoImpl implements MyReservationDao {
    private JdbcTemplate jdbcTemplate;

    public MyReservationDaoImpl(){}
    public MyReservationDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MyReservation> getAllMyReservation(String username) {
        String sql = "SELECT reservation_resources.resources_id AS resource_id, resource.name as name, \n" +
                "  resource.description AS description, reservation.start_date_time AS start_time, \n" +
                "  reservation.end_date_time AS end_time\n" +
                "FROM reservation\n" +
                "INNER JOIN reservation_resources ON reservation.id = reservation_resources.reservation_id\n" +
                "INNER JOIN resource ON reservation_resources.resources_id = resource.id\n" +
                "WHERE reservation.user_username ="+ "\'"+username+"\'";


        List<MyReservation> myReservationList = jdbcTemplate.query(sql, new RowMapper<MyReservation>() {
            @Override
            public MyReservation mapRow(ResultSet resultSet, int i) throws SQLException {
                return initMyReservation(resultSet);
            }
        });

        return myReservationList;
    }

    private MyReservation initMyReservation(ResultSet resultSet) throws SQLException {
        MyReservation myReservation = new MyReservation();

        myReservation.setName(resultSet.getString("name"));
        myReservation.setDate(resultSet.getString("start_time").substring(0,resultSet.getString("start_time").indexOf(" ")));
        myReservation.setDescription(resultSet.getString("description"));
        myReservation.setResourceId(resultSet.getLong("resource_id"));
        myReservation.setStart_time(resultSet.getString("start_time").substring(resultSet.getString("start_time").indexOf(" ")+1));
        myReservation.setEnd_time(resultSet.getString("end_time").substring(resultSet.getString("end_time").indexOf(" ")+1));
        return myReservation;
    }
}
