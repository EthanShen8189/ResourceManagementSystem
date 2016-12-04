package concordia.soen387.project.Services;

import concordia.soen387.project.Dao.*;
import concordia.soen387.project.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EthanShen on 2016-12-03.
 */
public class ResourceService {
    static ApplicationContext context;

    @Autowired
    static ResourceDao resourceDao;
    @Autowired
    static ComputerDao computerDao;
    @Autowired
    static ComputerOsDao computerOsDao;
    @Autowired
    static ProjectorDao projectorDao;
    @Autowired
    static RoomDao roomDao;
    @Autowired
    static WhiteBoardDao whiteBoardDao;

    static {
        if(context==null){
            context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        }
        if(resourceDao == null || computerDao == null || computerOsDao ==null || projectorDao==null || roomDao == null ||
                whiteBoardDao ==null){
            resourceDao = (ResourceDao) context.getBean("resourceDao");
            computerDao = (ComputerDao) context.getBean("computerDao");
            computerOsDao = (ComputerOsDao) context.getBean("computerOsDao");
            projectorDao = (ProjectorDao) context.getBean("projectorDao");
            roomDao = (RoomDao) context.getBean("roomDao");
            whiteBoardDao = (WhiteBoardDao) context.getBean("whiteBoardDao");
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

    public Computer getComputerById(long computerId){
        return computerDao.getComputerById(computerId);
    }

    public void updateComputer(Computer computer){
        computerDao.updateComputer(computer);
    }

    public List<ComputerOs> getAllComputerOs(){
        return computerOsDao.getAllComputerOs();
    }

    public Projector getProjectorById(long projectID){
        return projectorDao.getProjectorById(projectID);
    }

    public void updateProjector(Projector projector){
        projectorDao.updateProjector(projector);
    }

    public Room getRoomById(int roomId){
        return roomDao.getRoomById(roomId);
    }

    public void updateRoom(Room room){
        roomDao.updateRoom(room);
    }

    public void updateBoard(WhiteBoard whiteBoard){
        whiteBoardDao.updateWhiteBoard(whiteBoard);
    }

    public WhiteBoard getWhileboardById(long id){
        return whiteBoardDao.getWhiteBoardById(id);
    }



}
