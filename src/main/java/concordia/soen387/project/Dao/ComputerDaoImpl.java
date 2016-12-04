package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.Computer;

/**
 * Created by Van Do on 2016-12-03.
 */
public class ComputerDaoImpl implements ComputerDao{

	private JdbcTemplate jdbcTemplate;
	
	public ComputerDaoImpl(){}
	public ComputerDaoImpl(DataSource dataSource){
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	@Override
	public void addComputer(Computer computer) {
		 String sql = "INSERT INTO computer (dvi_output,hdmi_output,hostname, keyboard," +
                 " machine_type, manufacturer, model, mouse, speakers, vga_output, wired_networking,"+
				 "wireless_networking, id, operating_system_id)" + "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql, computer.getDvi_output(), computer.getHdmi_output(), computer.getHostname(), 
				 computer.getKeyboard(), computer.getMachine_type(), computer.getManufacturer(), computer.getModel(),
				 computer.getMouse(), computer.getSpeakers(), computer.getVga_output(), computer.getWired_networking(),
				 computer.getWireless_networking(),computer.getId(), computer.getOperating_system_id());
		
	}

	@Override
	public void updateComputer(Computer computer) {
			String sql = "UPDATE computer SET dvi_output=?, hdmi_output=?, hostname=?, keyboard=?, machine_type=?,"+
						"manufacturer =?, model=?, mouse=?, speakers=?, vga_output=?, wired_networking=?, wireless_networking=?,"+
						"id=?, operating_system_id=? WHERE id=? AND operating_system_id=?";
			jdbcTemplate.update(sql, computer.getDvi_output(), computer.getHdmi_output(), computer.getHostname(),
					 computer.getKeyboard(), computer.getMachine_type(), computer.getManufacturer(), computer.getModel(),
					 computer.getMouse(), computer.getSpeakers(), computer.getVga_output(), computer.getWired_networking(),
					 computer.getWireless_networking(),computer.getId(), computer.getOperating_system_id(), computer.getId(), computer.getOperating_system_id());
	}

	@Override
	public void deleteComputer(int id) {
		 String sql = "DELETE FROM computer WHERE id=?";
	     jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Computer getComputerById(long id) {
		String sql = "SELECT * FROM computer WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Computer>() {
            @Override
            public Computer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initComputer(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<Computer> getAllComputers() {
		String sql = "SELECT * FROM computer";
        List<Computer> computerList = jdbcTemplate.query(sql, new RowMapper<Computer>() {
            @Override
            public Computer mapRow(ResultSet resultSet, int i) throws SQLException {
                return initComputer(resultSet);
            }
        });

        return computerList;
	}

	@Override
	public Computer getLastIndexComputer() {
		String sql = "SELECT * FROM computer where id = (select max(id) from computer)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Computer>() {
			@Override
			public Computer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if(resultSet.next()){
					return initComputer(resultSet);
				}
				return null;
			}
		});
	}

	private Computer initComputer(ResultSet resultSet) throws SQLException{
		Computer computer = new Computer();
        computer.setDvi_output(resultSet.getBoolean("dvi_output"));
        computer.setHdmi_output(resultSet.getBoolean("hdmi_output"));
        computer.setHostname(resultSet.getString("hostname"));
        computer.setKeyboard(resultSet.getBoolean("keyboard"));
        computer.setMachine_type(resultSet.getString("machine_type"));
        computer.setManufacturer(resultSet.getString("manufacturer"));
        computer.setModel(resultSet.getString("model"));
        computer.setMouse(resultSet.getBoolean("mouse"));
        computer.setSpeakers(resultSet.getBoolean("speakers"));
        computer.setVga_output(resultSet.getBoolean("vga_output"));
        computer.setWired_networking(resultSet.getBoolean("wired_networking"));
        computer.setWireless_networking(resultSet.getBoolean("wireless_networking"));
        computer.setId(resultSet.getInt("id"));
        computer.setOperating_system_id(resultSet.getLong("operating_system_id"));

        return computer;
    }

}
