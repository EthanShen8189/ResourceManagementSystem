package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.Computer;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface ComputerDao {
	
	void addComputer(Computer computer);
	void updateComputer(Computer computer);
	void deleteComputer(int id);
	Computer getComputerById(long id);
	List<Computer> getAllComputers();
	Computer getLastIndexComputer();

}
