package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.ComputerOs;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface ComputerOsDao {

	 void addComputerOs(ComputerOs computerOs);
	 void updateComputerOs(ComputerOs computerOs);
	 void deleteComputerOs(int id);
	 ComputerOs getComputerOsById(int id);
	 List<ComputerOs> getAllComputerOs();
}
