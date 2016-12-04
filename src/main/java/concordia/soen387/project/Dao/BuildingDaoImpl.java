package concordia.soen387.project.Dao;


import concordia.soen387.project.Model.Building;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;

import javax.sql.DataSource;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Van Do on 2016-12-03.
 */
public class BuildingDaoImpl implements BuildingDao{

	private JdbcTemplate jdbcTemplate;
	
	public BuildingDaoImpl(){}
	public BuildingDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addBuilding(Building building) {
		 String sql = "INSERT INTO building (address,id) VALUE (?,?)";
		 jdbcTemplate.update(sql, building.getAddress(), building.getId());
		
	}

	@Override
	public void updateBuilding(Building building) {
		if(!(building.getAddress().equalsIgnoreCase(""))){
			String sql = "UPDATE building SET address=?, id=? WHERE id=?";
			jdbcTemplate.update(sql, building.getAddress(), building.getId(), building.getId());
		}
		
	}

	@Override
	public void deleteBuilding(int id) {
		 String sql = "DELETE FROM building WHERE id=?";
	     jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Building getBuildingById(int id) {
	      String sql = "SELECT * FROM building WHERE id=" + id;
	        return jdbcTemplate.query(sql, new ResultSetExtractor<Building>() {
	            @Override
	            public Building extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                if(resultSet.next()){
	                    return initBuilding(resultSet);
	                }

	                return null;
	            }
	        });
	}

	@Override
	public List<Building> getAllBuildings() {
		String sql = "SELECT * FROM building";
        List<Building> buildingList = jdbcTemplate.query(sql, new RowMapper<Building>() {
            @Override
            public Building mapRow(ResultSet resultSet, int i) throws SQLException {
                return initBuilding(resultSet);
            }
        });

        return buildingList;
	}
	
	private Building initBuilding(ResultSet resultSet) throws SQLException{
		Building building = new Building();
		building.setAddress(resultSet.getString("address"));
		building.setId(resultSet.getInt("id"));
		return building;
	}

}
