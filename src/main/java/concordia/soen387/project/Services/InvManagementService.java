package concordia.soen387.project.Services;

import concordia.soen387.project.Dao.*;
import concordia.soen387.project.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by EthanShen on 2016-12-03.
 */
public class InvManagementService {
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
    @Autowired
    static BuildingDao buildingDao;
    @Autowired
    static EmployeeDao employeeDao;

    static {
        if(context==null){
            context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        }
        if(resourceDao == null || computerDao == null || computerOsDao ==null || projectorDao==null || roomDao == null ||
                whiteBoardDao ==null || buildingDao == null || employeeDao == null){
            resourceDao = (ResourceDao) context.getBean("resourceDao");
            computerDao = (ComputerDao) context.getBean("computerDao");
            computerOsDao = (ComputerOsDao) context.getBean("computerOsDao");
            projectorDao = (ProjectorDao) context.getBean("projectorDao");
            roomDao = (RoomDao) context.getBean("roomDao");
            whiteBoardDao = (WhiteBoardDao) context.getBean("whiteBoardDao");
            buildingDao = (BuildingDao) context.getBean("buildingDao");
            employeeDao = (EmployeeDao) context.getBean("employeeDao");
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

    public Computer getLastIndexComp(){
        return computerDao.getLastIndexComputer();
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

    public WhiteBoard getWhiteBoardById(long id){
        return whiteBoardDao.getWhiteBoardById(id);
    }


    public List<Building> getAllBuilding() {
        return buildingDao.getAllBuildings();
    }

    public void insertComputer(Computer computer) {
        computerDao.addComputer(computer);
    }

    public Projector getLastIndexProjector() {
       return projectorDao.getLastIndexProjector();
    }

    public void insertProjector(Projector projector) {
        projectorDao.addProjector(projector);
    }

    public WhiteBoard getLastIndexWhiteboard() {
        return whiteBoardDao.getLastIndexWhiteboard();
    }

    public void insertWhiteboard(WhiteBoard whiteBoard) {
        whiteBoardDao.addWhiteBoard(whiteBoard);
    }

    public Room getLastIndexRoom() {
        return roomDao.getLastIndexRoom();
    }

    public void insertRoom(Room room) {
        roomDao.addRoom(room);
    }

    public Employee getEmployeeById(String username, int departmentId) {
       return employeeDao.getUserById(username,departmentId);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateUser(employee);
    }

    public List<Computer> getAllComputer(){
        return computerDao.getAllComputers();
    }

    public List<Room> getAllRoom() {
        return roomDao.getAllRooms();
    }

    public List<Projector> getAllProjector() {
        return projectorDao.getAllProjectors();
    }

    public List<WhiteBoard> getAllWhiteboard() {
        return whiteBoardDao.getAllWhiteBoard();
    }

    public Map<Long, Computer> queryComputerResource(){
        Map<Long,Computer> resourceComputerMap = new HashMap<>();
        Map<Long, Long> resourceComputerMapping = new HashMap<>();
        Map<Long, Computer> computerMap = new HashMap<>();

        List<Resource> resourceList = getAllResource();
        List<Computer> computerList = getAllComputer();
        Set<Long> UIDs = new HashSet<>();

        for(Computer computer: computerList){
            computerMap.put((long) computer.getId(), computer);
        }

        for(Resource resource: resourceList){
            if(resource.getDescription().toLowerCase().contains("computer")){
                resourceComputerMapping.put((long) resource.getId(), (long) resource.getResourceUID());
            }
        }

        UIDs = resourceComputerMapping.keySet();

        for(Long key: UIDs){
            resourceComputerMap.put(key, computerMap.get(key));
        }

        return resourceComputerMap;
    }

    public Map<Long, Room> queryRoomResource(){
        Map<Long,Room> resourceRoomMap = new HashMap<>();
        Map<Long, Long> resourceRoomMapping = new HashMap<>();
        Map<Long, Room> roomMap = new HashMap<>();

        List<Resource> resourceList = getAllResource();
        List<Room> roomList = getAllRoom();
        Set<Long> UIDs = new HashSet<>();

        for(Room room: roomList){
            roomMap.put((long) room.getId(), room);
        }

        for(Resource resource: resourceList){
            if(resource.getDescription().toLowerCase().contains("room")){
                resourceRoomMapping.put((long) resource.getId(), (long) resource.getResourceUID());
            }
        }

        UIDs = resourceRoomMapping.keySet();

        for(Long key: UIDs){
            resourceRoomMap.put(key, roomMap.get(key));
        }

        return resourceRoomMap;
    }

    public Map<Long, Projector> queryProjectorResource(){
        Map<Long,Projector> resourceProjectorMap = new HashMap<>();
        Map<Long, Long> resourceProjectorMapping = new HashMap<>();
        Map<Long, Projector> projectorMap = new HashMap<>();

        List<Resource> resourceList = getAllResource();
        List<Projector> projectorList = getAllProjector();
        Set<Long> UIDs = new HashSet<>();

        for(Projector projector: projectorList){
            projectorMap.put((long) projector.getId(), projector);
        }

        for(Resource resource: resourceList){
            if(resource.getDescription().toLowerCase().contains("projector")){
                resourceProjectorMapping.put((long) resource.getId(), (long) resource.getResourceUID());
            }
        }

        UIDs = resourceProjectorMapping.keySet();

        for(Long key: UIDs){
            resourceProjectorMap.put(key, projectorMap.get(key));
        }

        return resourceProjectorMap;
    }

    public Map<Long, WhiteBoard> queryWhiteBoardResource(){
        Map<Long,WhiteBoard> resourceWhiteboardMap = new HashMap<>();
        Map<Long, Long> resourceWhiteboardMapping = new HashMap<>();
        Map<Long, WhiteBoard> whiteboardMap = new HashMap<>();

        List<Resource> resourceList = getAllResource();
        List<WhiteBoard> whiteboardList = getAllWhiteboard();
        Set<Long> UIDs = new HashSet<>();

        for(WhiteBoard whiteboard: whiteboardList){
            whiteboardMap.put((long) whiteboard.getId(), whiteboard);
        }

        for(Resource resource: resourceList){
            if(resource.getDescription().toLowerCase().contains("board")){
                resourceWhiteboardMapping.put((long) resource.getId(), (long) resource.getResourceUID());
            }
        }

        UIDs = resourceWhiteboardMapping.keySet();

        for(Long key: UIDs){
            resourceWhiteboardMap.put(key, whiteboardMap.get(key));
        }

        return resourceWhiteboardMap;
    }




}
