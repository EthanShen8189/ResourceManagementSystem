package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.*;
import concordia.soen387.project.Services.InvManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by EthanShen on 2016-12-03.
 */

@Controller
public class InvManagementController {

    private InvViewController invViewController = InvViewController.getInvViewController();
    private InvManagementService invManagementService = new InvManagementService();

    @RequestMapping(value = "/searchInv", method = RequestMethod.GET, params = {"search"})
    public ModelAndView searchResource(@RequestParam String search){
        ArrayList<Resource> resourceArrayList = new ArrayList<>();
        if(!search.equals("")) {
            if (invManagementService.getResourceByID(Long.parseLong(search)) != null) {
                resourceArrayList.add(invManagementService.getResourceByID(Long.parseLong(search)));
                return invViewController.manageInventoryTab(resourceArrayList, "");
            } else {
                return invViewController.manageInventoryTab(null, "Wrong Resource ID");
            }
        }else{
            return invViewController.manageInventoryTab(null, "Please enter resource ID or click See All Resource");
        }

    }

    @RequestMapping(value = "/searchAllResource", method = RequestMethod.GET)
    public ModelAndView searchResource(){
        return invViewController.manageInventoryTab((ArrayList<Resource>) invManagementService.getAllResource(), "");
    }

    @RequestMapping(value = "/updateComputer", method = RequestMethod.POST)
    public ModelAndView updateComputer(@RequestParam String computerID, @RequestParam String resourceID,
                                       @RequestParam String hostName,
                                       @RequestParam String machineType, @RequestParam String operatingSystem,
                                       @RequestParam String manufacturer, @RequestParam String model,
                                       @RequestParam (value = "moveable", required = false) String moveable,
                                       @RequestParam (value = "wirelessnetworking", required = false) String wirelessnetworking,
                                       @RequestParam (value = "wirednetworking", required = false)String wirednetworking,
                                       @RequestParam (value = "speakersincluded", required = false)String speakersincluded,
                                       @RequestParam (value = "keyboardincluded", required = false)String keyboardincluded,
                                       @RequestParam (value = "mouseincluded", required = false)String mouseincluded,
                                       @RequestParam (value = "hdmiout", required = false)String hdmiout,
                                       @RequestParam (value = "dviout", required = false)String dviout,
                                       @RequestParam (value = "vgaout", required = false)String vgaout){
        Computer computer;
        Resource resource;
        try {
            computer = invManagementService.getComputerById(Long.parseLong(computerID));
            resource = invManagementService.getResourceByID(Long.parseLong(resourceID));

            computer.setHostname(hostName);
            computer.setMachine_type(machineType);
            computer.setOperating_system_id(Long.parseLong(operatingSystem.substring(0, 1)));
            computer.setManufacturer(manufacturer);
            computer.setModel(model);
            computer.setWireless_networking(!(wirelessnetworking == null));
            computer.setWired_networking(!(wirednetworking==null));
            computer.setSpeakers(!(speakersincluded==null));
            computer.setKeyboard(!(keyboardincluded==null));
            computer.setMouse(!(mouseincluded==null));
            computer.setHdmi_output(!(hdmiout==null));
            computer.setDvi_output(!(dviout==null));
            computer.setVga_output(!(vgaout==null));

            invManagementService.updateComputer(computer);

            resource.setMovable(!(moveable==null));

            invManagementService.updateResource(resource);

            return searchResource(resourceID);
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.manageInventoryTab(null, "Update failed, please try again");
        }
    }

    @RequestMapping(value = "/updateProjector", method = RequestMethod.POST)
    public ModelAndView updateProjector(@RequestParam String projectorID, @RequestParam String resourceID,
                                        @RequestParam String projectorHeight,
                                        @RequestParam String projectorWidth,
                                        @RequestParam (value = "projectorMovable", required = false) String projectorMovable,
                                        @RequestParam (value = "hdmiin", required = false) String hdmiin,
                                        @RequestParam (value = "dviin", required = false)String dviin,
                                        @RequestParam (value = "vgain", required = false)String vgain){
        Projector projector;
        Resource resource;
        try{
            projector = invManagementService.getProjectorById(Long.parseLong(projectorID));
            resource = invManagementService.getResourceByID(Long.parseLong(resourceID));

            projector.setHeight(Integer.parseInt(projectorHeight));
            projector.setWidth(Integer.parseInt(projectorWidth));
            projector.setDvi_input(!(dviin==null));
            projector.setDvi_input(!(hdmiin==null));
            projector.setVga_input(!(vgain==null));

            invManagementService.updateProjector(projector);

            resource.setMovable(!(projectorMovable==null));

            invManagementService.updateResource(resource);

            return searchResource(resourceID);
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.manageInventoryTab(null, "Update failed, please try again");
        }
    }

    @RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
    public ModelAndView updateRoom(@RequestParam String roomID, @RequestParam String resourceID, @RequestParam String roomNumber){
        Room room;
        try {
            room = invManagementService.getRoomById(Integer.parseInt(roomID));
            room.setRoom_number(roomNumber);
            invManagementService.updateRoom(room);

            return searchResource(resourceID);
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.manageInventoryTab(null, "Update failed, please try again");
        }
    }

    @RequestMapping(value = "/updatewhiteboard", method = RequestMethod.POST)
    public ModelAndView updateWhiteboard (@RequestParam String whiteBoardID, @RequestParam String resourceID,
                                          @RequestParam String boardWidth, @RequestParam String boardHeight,
                                         @RequestParam String movable){
        WhiteBoard whiteBoard;
        Resource resource;
        try{
            whiteBoard = invManagementService.getWhiteBoardById(Long.parseLong(whiteBoardID));
            resource = invManagementService.getResourceByID(Long.parseLong(resourceID));

            whiteBoard.setWidth(Integer.parseInt(boardWidth));
            whiteBoard.setHeight(Integer.parseInt(boardHeight));

            invManagementService.updateBoard(whiteBoard);

            resource.setMovable(!(movable==null));

            invManagementService.updateResource(resource);

            return searchResource(resourceID);
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.manageInventoryTab(null, "Update failed, please try again");
        }
    }

    @RequestMapping(value = "/addCompForm", method = RequestMethod.POST)
    public ModelAndView addComputer(@RequestParam String hostName, @RequestParam String description,
                                    @RequestParam String machineType, @RequestParam String operatingSystem,
                                    @RequestParam String manufacturer, @RequestParam String model,
                                    @RequestParam (value = "movable", required = false) String movable,
                                    @RequestParam (value = "wirelessnetworking", required = false) String wirelessnetworking,
                                    @RequestParam (value = "wirednetworking", required = false)String wirednetworking,
                                    @RequestParam (value = "speakersincluded", required = false)String speakersincluded,
                                    @RequestParam (value = "keyboardincluded", required = false)String keyboardincluded,
                                    @RequestParam (value = "mouseincluded", required = false)String mouseincluded,
                                    @RequestParam (value = "hdmiout", required = false)String hdmiout,
                                    @RequestParam (value = "dviout", required = false)String dviout,
                                    @RequestParam (value = "vgaout", required = false)String vgaout){
        Computer computer;
        Resource resource = new Resource();
        try {
            computer = invManagementService.getLastIndexComp();

            computer.setId(computer.getId()+1);
            computer.setHostname(hostName);
            computer.setMachine_type(machineType);
            computer.setOperating_system_id(Long.parseLong(operatingSystem.substring(0, 1)));
            computer.setManufacturer(manufacturer);
            computer.setModel(model);
            computer.setWireless_networking(wirelessnetworking != null);
            computer.setWired_networking(!(wirednetworking==null));
            computer.setSpeakers(!(speakersincluded==null));
            computer.setKeyboard(!(keyboardincluded==null));
            computer.setMouse(!(mouseincluded==null));
            computer.setHdmi_output(!(hdmiout==null));
            computer.setDvi_output(!(dviout==null));
            computer.setVga_output(!(vgaout==null));

            invManagementService.insertComputer(computer);

            resource.setAvailable(true);
            resource.setDescription(description);
            resource.setName("Computer");
            resource.setResourceUID(computer.getId());
            resource.setMovable(!(movable==null));

            invManagementService.insertResource(resource);

            return invViewController.addComputerPage("Successfully Added!");
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.addComputerPage("Something Wrong, Please try again.");
        }
    }

    @RequestMapping(value = "/AddProjForm", method = RequestMethod.POST)
    public ModelAndView addProjector(@RequestParam String projectorHeight, @RequestParam String projectorWidth,
                                     @RequestParam (value = "movable", required = false) String projectorMovable,
                                     @RequestParam (value = "hdmiin", required = false) String hdmiin,
                                     @RequestParam (value = "dviin", required = false)String dviin,
                                     @RequestParam (value = "vgain", required = false)String vgain,
                                     @RequestParam String description){
        Projector projector;
        Resource resource = new Resource();

        try {
            projector = invManagementService.getLastIndexProjector();

            projector.setId(projector.getId()+1);
            projector.setHeight(Integer.parseInt(projectorHeight));
            projector.setWidth(Integer.parseInt(projectorWidth));
            projector.setDvi_input(!(dviin==null));
            projector.setDvi_input(!(hdmiin==null));
            projector.setVga_input(!(vgain==null));

            invManagementService.insertProjector(projector);

            resource.setAvailable(true);
            resource.setDescription(description);
            resource.setName("Projector");
            resource.setResourceUID(projector.getId());
            resource.setMovable(!(projectorMovable==null));

            invManagementService.insertResource(resource);
            return invViewController.addProjectorPage("Successfully Added!");
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.addProjectorPage("Something Wrong, Please try again.");
        }

    }

    @RequestMapping(value = "/addBoardform", method = RequestMethod.POST)
    public ModelAndView addWhiteboard(@RequestParam String description, @RequestParam String boardWidth,
                                      @RequestParam String boardHeight, @RequestParam String movable){
        WhiteBoard whiteBoard;
        Resource resource = new Resource();

        try {
            whiteBoard = invManagementService.getLastIndexWhiteboard();
            whiteBoard.setId(whiteBoard.getId()+1);
            whiteBoard.setWidth(Integer.parseInt(boardWidth));
            whiteBoard.setHeight(Integer.parseInt(boardHeight));

            invManagementService.insertWhiteboard(whiteBoard);

            resource.setName("Whiteboard");
            resource.setDescription(description);
            resource.setAvailable(true);
            resource.setMovable(!(movable==null));

            invManagementService.insertResource(resource);

            return invViewController.addWhiteboardPage("Successfully Added!");
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.addWhiteboardPage("Something Wrong, Please try again.");
        }
    }

    @RequestMapping(value = "/addRoomform", method = RequestMethod.POST)
    public ModelAndView addRoom(@RequestParam String roomNumber, @RequestParam String building,@RequestParam String description){
        Room room;
        Resource resource = new Resource();
        try {
            room = invManagementService.getLastIndexRoom();
            room.setId(room.getId()+1);
            room.setRoom_number(roomNumber);
            room.setBuilding_id(Integer.parseInt(building.substring(0,1)));

            invManagementService.insertRoom(room);

            resource.setMovable(false);
            resource.setAvailable(true);
            resource.setDescription(description);
            resource.setName("Room");
            resource.setResourceUID((int) room.getId());

            invManagementService.insertResource(resource);
            return invViewController.addRoomPage("Successfully Added!");
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.addRoomPage("Something Wrong, Please try again.");
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam String username, @RequestParam String departmentId,
                                       @RequestParam String oldPassword, @RequestParam String newPassword,
                                       @RequestParam String confirmPassword){
        if(!confirmPassword.equals(newPassword)){
            return invViewController.accountSettingTab("","Confirm Password is not matching with new password.");
        }else if(oldPassword.equals(newPassword)){
            return invViewController.accountSettingTab("","New password cannot be the same as old password");
        }else if(!oldPassword.equals(invViewController.getPassword())){
            return invViewController.accountSettingTab("","Old password wrong, please try again.");
        }else if(confirmPassword.equals(newPassword)){
            Employee employee = invManagementService.getEmployeeById(username, Integer.parseInt(departmentId));
            employee.setPassword(newPassword);

            invManagementService.updateEmployee(employee);
            return invViewController.accountSettingTab("Password Changed!","");
        }
        return invViewController.accountSettingTab("","Something is wrong, please try again.");
    }
}
