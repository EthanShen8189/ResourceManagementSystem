package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.*;
import concordia.soen387.project.Services.ResourceService;
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

    private InvViewController invViewController = new InvViewController();
    private ResourceService resourceService = new ResourceService();

    @RequestMapping(value = "/searchInv", method = RequestMethod.GET, params = {"search"})
    public ModelAndView searchResource(@RequestParam String search){
        ArrayList<Resource> resourceArrayList = new ArrayList<>();
        if(!search.equals("")) {
            if (resourceService.getResourceByID(Long.parseLong(search)) != null) {
                resourceArrayList.add(resourceService.getResourceByID(Long.parseLong(search)));
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
        return invViewController.manageInventoryTab((ArrayList<Resource>) resourceService.getAllResource(), "");
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
            computer = resourceService.getComputerById(Long.parseLong(computerID));
            resource = resourceService.getResourceByID(Long.parseLong(resourceID));

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

            resourceService.updateComputer(computer);

            resource.setMovable(!(moveable==null));

            resourceService.updateResource(resource);

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
            projector = resourceService.getProjectorById(Long.parseLong(projectorID));
            resource = resourceService.getResourceByID(Long.parseLong(resourceID));

            projector.setHeight(Integer.parseInt(projectorHeight));
            projector.setWidth(Integer.parseInt(projectorWidth));
            projector.setDvi_input(!(dviin==null));
            projector.setDvi_input(!(hdmiin==null));
            projector.setVga_input(!(vgain==null));

            resourceService.updateProjector(projector);

            resource.setMovable(!(projectorMovable==null));

            resourceService.updateResource(resource);

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
            room = resourceService.getRoomById(Integer.parseInt(roomID));
            room.setRoom_number(roomNumber);
            resourceService.updateRoom(room);

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
            whiteBoard = resourceService.getWhiteBoardById(Long.parseLong(whiteBoardID));
            resource = resourceService.getResourceByID(Long.parseLong(resourceID));

            whiteBoard.setWidth(Integer.parseInt(boardWidth));
            whiteBoard.setHeight(Integer.parseInt(boardHeight));

            resourceService.updateBoard(whiteBoard);

            resource.setMovable(!(movable==null));

            resourceService.updateResource(resource);

            return searchResource(resourceID);
        }catch (Exception e){
            e.printStackTrace();
            return invViewController.manageInventoryTab(null, "Update failed, please try again");
        }
    }
}
