package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Resource;

import java.util.List;

/**
 * Created by EthanShen on 2016-12-03.
 */
public interface ResourceDao {
    void addResource(Resource resource);
    void updateResource(Resource resource);
    void deleteResource(int resourceID);
    Resource getResourceById(long resourceID);
    List<Resource> getAllResource();

}
