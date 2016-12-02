package concordia.soen387.project.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by EthanShen on 2016-12-02.
 */
public class ReservationDaoImpl implements ReservationDao{

    private JdbcTemplate jdbcTemplate;

    public ReservationDaoImpl(){}

    public ReservationDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
