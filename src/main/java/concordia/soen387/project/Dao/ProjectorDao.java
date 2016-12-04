package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.Projector;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface ProjectorDao {

	void addProjector(Projector projector);
	void updateProjector(Projector projector);
	void deleteProjector(int id);
	Projector getProjectorById(long id);
	List<Projector> getAllProjectors();
	Projector getLastIndexProjector();
}
