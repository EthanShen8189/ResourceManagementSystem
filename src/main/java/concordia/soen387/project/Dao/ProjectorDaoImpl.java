package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.Projector;

/**
 * Created by Van Do on 2016-12-03.
 */
public class ProjectorDaoImpl implements ProjectorDao{

	private JdbcTemplate jdbcTemplate;
	
	public ProjectorDaoImpl(){}
	public ProjectorDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addProjector(Projector projector) {
		String sql = "INSERT INTO projector (dvi_input,hdmi_input,height,width,vga_input,id)" +
				"VALUE (?,?,?,?,?,?)";
		 jdbcTemplate.update(sql, projector.getDvi_input(), projector.getHdmi_input(), projector.getHeight(),
				 projector.getWidth(), projector.getVga_input(), projector.getId());
		
	}

	@Override
	public void updateProjector(Projector projector) {
		if(!(projector.getId() < 0)){
			String sql = "UPDATE projector SET dvi_input=?, hdmi_input=?, height=?, width=? , vga_input=?, id=? WHERE id=?";
			jdbcTemplate.update(sql, projector.getDvi_input(), projector.getHdmi_input(), projector.getHeight(), projector.getWidth(),
					projector.getVga_input(), projector.getId(), projector.getId());
		}
		
	}

	@Override
	public void deleteProjector(int id) {
		String sql = "DELETE FROM projector WHERE id=?";
	    jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Projector getProjectorById(long id) {
		String sql = "SELECT * FROM projector WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Projector>() {
            @Override
            public Projector extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initProjector(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<Projector> getAllProjectors() {
		String sql = "SELECT * FROM projector";
        List<Projector> buildingList = jdbcTemplate.query(sql, new RowMapper<Projector>() {
            @Override
            public Projector mapRow(ResultSet resultSet, int i) throws SQLException {
                return initProjector(resultSet);
            }
        });

        return buildingList;
	}

	@Override
	public Projector getLastIndexProjector() {
		String sql = "SELECT * FROM projector where id = (select max(id) from projector)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Projector>() {
			@Override
			public Projector extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if(resultSet.next()){
					return initProjector(resultSet);
				}
				return null;
			}
		});
	}


	private Projector initProjector(ResultSet resultSet) throws SQLException{
		Projector projector = new Projector();
		projector.setDvi_input(resultSet.getBoolean("dvi_input"));
		projector.setHdmi_input(resultSet.getBoolean("hdmi_input"));
		projector.setHeight(resultSet.getInt("height"));
		projector.setWidth(resultSet.getInt("width"));
		projector.setVga_input(resultSet.getBoolean("vga_input"));
		projector.setId(resultSet.getInt("id"));
		return projector;
	}

	

}
