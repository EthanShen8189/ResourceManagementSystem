package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.ComputerOs;

/**
 * Created by Van Do on 2016-12-03.
 */
public class ComputerOsDaoImpl implements ComputerOsDao{

	private JdbcTemplate jdbcTemplate;
	
	public ComputerOsDaoImpl(){}
	public ComputerOsDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void addComputerOs(ComputerOs computerOs) {
		String sql = "INSERT INTO computeros (id,license,version,os_type) VALUE (?,?,?,?)";
		jdbcTemplate.update(sql, computerOs.getId(), computerOs.getLicense(), computerOs.getVersion(),
				computerOs.getOs_type());
		
	}

	@Override
	public void updateComputerOs(ComputerOs computerOs) {
		if(!(computerOs.getLicense().equalsIgnoreCase(""))){
			String sql = "UPDATE computeros SET id=?, license=?, version=?, os_type=? WHERE id=?";
			jdbcTemplate.update(sql, computerOs.getId(), computerOs.getLicense(), computerOs.getVersion(),
					computerOs.getOs_type(), computerOs.getId());
		}
		
	}

	@Override
	public void deleteComputerOs(int id) {
		 String sql = "DELETE FROM computeros WHERE id=?";
	        jdbcTemplate.update(sql, id);
		
	}

	@Override
	public ComputerOs getComputerOsById(int id) {
		String sql = "SELECT * FROM computeros WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<ComputerOs>() {
            @Override
            public ComputerOs extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initComputerOs(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<ComputerOs> getAllComputerOs() {
		String sql = "SELECT * FROM computeros";
        List<ComputerOs> computerOsList = jdbcTemplate.query(sql, new RowMapper<ComputerOs>() {
            @Override
            public ComputerOs mapRow(ResultSet resultSet, int i) throws SQLException {
                return initComputerOs(resultSet);
            }
        });

        return computerOsList;
	}
	
	private ComputerOs initComputerOs(ResultSet resultSet) throws SQLException{
		ComputerOs computerOs = new ComputerOs();
		computerOs.setId(resultSet.getInt("id"));
		computerOs.setLicense(resultSet.getString("license"));
		computerOs.setVersion(resultSet.getInt("version"));
		computerOs.setOs_type(resultSet.getString("os_type"));
		return computerOs;
	}


}
