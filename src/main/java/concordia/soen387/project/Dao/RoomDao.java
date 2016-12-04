package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.Room;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface RoomDao {

	void addRoom(Room room);
	void updateRoom(Room room);
	void deleteRoom(int id);
	Room getRoomById(int id);
	List<Room> getAllRooms();
	Room getLastIndexRoom();
}
