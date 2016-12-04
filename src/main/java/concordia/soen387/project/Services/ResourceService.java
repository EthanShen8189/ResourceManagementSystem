package concordia.soen387.project.Services;

import concordia.soen387.project.Dao.ResourceDao;
import concordia.soen387.project.Model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by EthanShen on 2016-12-03.
 */
public class ResourceService {
    static ApplicationContext context;

    @Autowired
    static ResourceDao resourceDao;

    static {
        if(context==null){
            context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        }
        if(resourceDao == null){
            resourceDao = (ResourceDao) context.getBean("resourceDao");
        }
    }

    public List<Resource> getAllResource(){
        return resourceDao.getAllResource();
    }

    public Resource getResourceByID(long resourceId){
        return resourceDao.getResourceById(resourceId);
    }

    public void insertResource(Resource resource){
        resourceDao.addResource(resource);
    }

    public void updateResource(Resource resource){
        resourceDao.updateResource(resource);
    }
}
