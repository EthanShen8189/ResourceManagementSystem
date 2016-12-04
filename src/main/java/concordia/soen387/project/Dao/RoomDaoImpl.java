package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.Room;

/**
 * Created by Van Do on 2016-12-03.
 */
public class RoomDaoImpl implements RoomDao {

	
	private JdbcTemplate jdbcTemplate;
	
	public RoomDaoImpl(){}
	public RoomDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addRoom(Room room) {
		String sql = "INSERT INTO room (room_number,id, building_id) VALUE (?,?,?)";
		 jdbcTemplate.update(sql, room.getRoom_number(), room.getId(), room.getBuilding_id());
		
	}

	@Override
	public void updateRoom(Room room) {
		if(!(room.getRoom_number().equalsIgnoreCase("") && room.getId() < 0 && room.getBuilding_id() <0)){
			String sql = "UPDATE room SET room_number=?, id=?, building_id=? WHERE id=?";
			jdbcTemplate.update(sql, room.getRoom_number(), room.getId(), room.getBuilding_id(), room.getId());
		}
		
	}

	@Override
	public void deleteRoom(int id) {
		 String sql = "DELETE FROM room WHERE id=?";
	     jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Room getRoomById(int id) {
		String sql = "SELECT * FROM room WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Room>() {
            @Override
            public Room extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initRoom(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<Room> getAllRooms() {
		String sql = "SELECT * FROM room";
        List<Room> roomList = jdbcTemplate.query(sql, new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet resultSet, int i) throws SQLException {
                return initRoom(resultSet);
            }
        });

        return roomList;
	}

	@Override
	public Room getLastIndexRoom() {
		String sql = "SELECT * FROM room where id = (select max(id) from room)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Room>() {
			@Override
			public Room extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if(resultSet.next()){
					return initRoom(resultSet);
				}
				return null;
			}
		});
	}

	private Room initRoom(ResultSet resultSet) throws SQLException{
		Room room = new Room();
		room.setRoom_number(resultSet.getString("room_number"));
		room.setId(resultSet.getInt("id"));
		room.setBuilding_id(resultSet.getInt("building_id"));
		
		return room;
	}

}
