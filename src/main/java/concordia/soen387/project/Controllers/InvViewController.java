package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.*;
import concordia.soen387.project.Services.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InvViewController {
	
	private ModelAndView modelAndView = new ModelAndView();
	private ResourceService resourceService = new ResourceService();

	@RequestMapping(value = "/manageInventory")
	public ModelAndView manageInventoryTab(ArrayList<Resource> resourceArrayList, String msg){
		modelAndView.setViewName("inventory/invIndex");
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
	public ModelAndView accountSettingTab(){
		modelAndView.setViewName("inventory/invIndex");
		modelAndView.addObject("accountSettingsTabActive", "active");
		modelAndView.addObject("manageInventoryTabActive","");
		modelAndView.addObject("addInventoryTabActive","");
		modelAndView.addObject("selectedTab", "../../jsp/inventory/accountSettings.jsp");
		return modelAndView;
		
	}
	@RequestMapping(value = "/addInventory")
	public ModelAndView addInventoryTab(){
		modelAndView.setViewName("inventory/invIndex");
		modelAndView.addObject("accountSettingsTabActive", "");
		modelAndView.addObject("addInventoryTabActive","active");
		modelAndView.addObject("manageInventoryTabActive","");
		modelAndView.addObject("selectedTab", "../../jsp/inventory/addInventoryForm.jsp");
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
				List<ComputerOs> osList = resourceService.getAllComputerOs();
				Resource resource = resourceService.getResourceByID(Long.parseLong(resourceId));
                computerList.add(resourceService.getComputerById(resourceUID));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("computer", computerList);
				modelAndView.addObject("osList", osList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editComputer.jsp");
			}else if(resourceDesc.toLowerCase().contains("projector") && resourceUID > 0){
				List<Projector> projectorList = new ArrayList<>();
				projectorList.add(resourceService.getProjectorById(resourceUID));
				Resource resource = resourceService.getResourceByID(Long.parseLong(resourceId));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("projector", projectorList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editProjector.jsp");
			}else if(resourceDesc.toLowerCase().contains("room") && resourceUID > 0){
				List<Room> roomList = new ArrayList<>();
				roomList.add(resourceService.getRoomById((int) resourceUID));
				Resource resource = resourceService.getResourceByID(Long.parseLong(resourceId));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("room", roomList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editRoom.jsp");
			}else if(resourceDesc.toLowerCase().contains("white") && resourceUID > 0){
				List<WhiteBoard> whiteBoardList = new ArrayList<>();
				whiteBoardList.add(resourceService.getWhiteBoardById(resourceUID));
				Resource resource = resourceService.getResourceByID(Long.parseLong(resourceId));

				modelAndView.setViewName("inventory/invIndex");
				modelAndView.addObject("resourceId", resourceId);
				modelAndView.addObject("movableCheck", resource.getMovable());
				modelAndView.addObject("whiteboard", whiteBoardList);
				modelAndView.addObject("selectedTab", "../../jsp/inventory/editWhiteboard.jsp");
			}
		}
		return modelAndView;
		
	}

}
