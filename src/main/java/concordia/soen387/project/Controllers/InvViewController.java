package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.*;
import concordia.soen387.project.Services.InvManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class InvViewController {

	private static InvViewController invViewController = new InvViewController();
	private ModelAndView modelAndView = new ModelAndView();
	private InvManagementService invManagementService = new InvManagementService();
	private static String userName;
	private static String firstName;
	private static String password;
	private static long department_id;

	private InvViewController(){}

	static InvViewController getInvViewController(){
		return invViewController;
	}

	void setUserName(String userName) {
		InvViewController.userName = userName;
	}

	void setFirstName(String firstName) {
		InvViewController.firstName = firstName;
	}

	void setDepartment_id(long department_id) {
		InvViewController.department_id = department_id;
	}

	void setPassword(String password) {
		InvViewController.password = password;
	}

	String getUserName() {
		return userName;
	}

	String getFirstName() {
		return firstName;
	}

	String getPassword() {
		return password;
	}

	long getDepartment_id() {
		return department_id;
	}

	@RequestMapping(value = "/manageInventory")
	public ModelAndView manageInventoryTab(ArrayList<Resource> resourceArrayList, String msg){
		modelAndView.setViewName("inventory/invIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("manageInventoryTabActive", "active");
		modelAndView.addObject("accountSettingsTabActive", "");
		modelAndView.addObject("addInventoryTabActive","");
		modelAndView.addObject("selectedTab", "../../jsp/inventory/manageInventory.jsp");
		if(resourceArrayList != null) {
			modelAndView.addObject("resourceList", resourceArrayList);
			modelAndView.addObject("errorMsg", msg);
		}else {
			modelAndView.addObject("errorMsg", msg);
		}
		return modelAndView;
		
	}

	@RequestMapping(value = "/accountSetting")
	public ModelAndView accountSettingTab(String successMsg, String errorMsg){
		modelAndView.setViewName("inventory/invIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("accountSettingsTabActive", "active");
		modelAndView.addObject("manageInventoryTabActive","");
		modelAndView.addObject("addInventoryTabActive","");
		modelAndView.addObject("successMsg", successMsg);
		modelAndView.addObject("errorMsg", errorMsg);
		modelAndView.addObject("selectedTab", "../../jsp/inventory/accountSettings.jsp");
		return modelAndView;
		
	}
	@RequestMapping(value = "/addInventory")
	public ModelAndView addInventoryTab(String url, String type, String msg){
		modelAndView.setViewName("inventory/invIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("accountSettingsTabActive", "");
		modelAndView.addObject("addInventoryTabActive","active");
		modelAndView.addObject("manageInventoryTabActive","");
		modelAndView.addObject("selectedTab", "../../jsp/inventory/addInventoryForm.jsp");
		if(type!=null && type.equalsIgnoreCase("computer")){
			modelAndView.addObject("osList", invManagementService.getAllComputerOs());
		}else if(type!=null && type.equalsIgnoreCase("room")){
			modelAndView.addObject("buildingList", invManagementService.getAllBuilding());
		}
		if(url != null) {
			modelAndView.addObject("addInventoryPage", url);
		}
		if(msg != null) {
			modelAndView.addObject("insertMsg", msg);
		}
		return modelAndView;

	}

	@RequestMapping(value = "/editResource", method = RequestMethod.POST, params = {"editParam", "resourceId"})
	public ModelAndView updateResourceView(@RequestParam String editParam, @RequestParam String resourceId){
		String resourceDesc;
		long resourceUID;
		if(!editParam.equals("")) {
			resourceDesc = editParam.substring(0, editParam.indexOf("/"));
			resourceUID = Long.parseLong(editParam.substring(editParam.indexOf("/") + 1));
			if(resourceDesc.toLowerCase().contains("computer") && resourceUID > 0){
				List<Computer> computerList = new ArrayList<>();
				List<ComputerOs> osList = invManagementService.getAllComputerOs();
				Resource resource = invManagementService.getResourceByID(Long.parseLong(resourceId));
                computerList.add(invManagementService.getComputerById(resourceUID));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("computer", computerList);
				modelAndView.addObject("osList", osList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editComputer.jsp");
			}else if(resourceDesc.toLowerCase().contains("projector") && resourceUID > 0){
				List<Projector> projectorList = new ArrayList<>();
				projectorList.add(invManagementService.getProjectorById(resourceUID));
				Resource resource = invManagementService.getResourceByID(Long.parseLong(resourceId));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("projector", projectorList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editProjector.jsp");
			}else if(resourceDesc.toLowerCase().contains("room") && resourceUID > 0){
				List<Room> roomList = new ArrayList<>();
				roomList.add(invManagementService.getRoomById((int) resourceUID));
				Resource resource = invManagementService.getResourceByID(Long.parseLong(resourceId));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("room", roomList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editRoom.jsp");
			}else if(resourceDesc.toLowerCase().contains("white") && resourceUID > 0){
				List<WhiteBoard> whiteBoardList = new ArrayList<>();
				whiteBoardList.add(invManagementService.getWhiteBoardById(resourceUID));
				Resource resource = invManagementService.getResourceByID(Long.parseLong(resourceId));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("whiteboard", whiteBoardList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editWhiteboard.jsp");
			}
		}
		return modelAndView;
		
	}

	@RequestMapping(value = "/addComputerPage")
	public ModelAndView addComputerPage(String msg){
		return addInventoryTab("../../jsp/inventory/addComputerForm.jsp", "computer", msg);
	}

	@RequestMapping(value = "/addWhiteboardPage")
	public ModelAndView addWhiteboardPage(String msg){
		return addInventoryTab("../../jsp/inventory/addWhiteboardPage.jsp", "", msg);
	}

	@RequestMapping(value = "/addRoomPage")
	public ModelAndView addRoomPage(String msg){
		return addInventoryTab("../../jsp/inventory/addRoomPage.jsp", "room", msg);
	}

	@RequestMapping(value = "/addProjectorPage")
	public ModelAndView addProjectorPage(String msg){
		return addInventoryTab("../../jsp/inventory/addProjectorPage.jsp", "",msg);
	}

}
