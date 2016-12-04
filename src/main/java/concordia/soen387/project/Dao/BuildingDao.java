package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Building;
import java.util.List;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface BuildingDao {
	
	void addBuilding(Building building);
	void updateBuilding(Building building);
	void deleteBuilding(int id);
	Building getBuildingById(int id);
	List<Building> getAllBuildings();
	
}
