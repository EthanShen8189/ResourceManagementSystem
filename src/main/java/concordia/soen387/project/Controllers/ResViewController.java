package concordia.soen387.project.Controllers;

import concordia.soen387.project.Model.Resource;
import concordia.soen387.project.Services.InvManagementService;
import concordia.soen387.project.Services.ResService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResViewController {
	
	private static ResViewController resViewController = new ResViewController();
	private ModelAndView modelAndView = new ModelAndView();
	private InvManagementService invManagementService = new InvManagementService();
	private static ResService resService = new ResService();

	private static String userName;
	private static String firstName;
	private static String password;
	private static long department_id;
	//private ResNavigationBarService resNavigationBarService = new ResNavigationBarService();

	private ResViewController(){}

	static ResViewController getResViewController(){
		return resViewController;
	}

	void setUserName(String userName) {
		ResViewController.userName = userName;
	}

	void setFirstName(String firstName) {
		ResViewController.firstName = firstName;
	}

	void setPassword(String password) {
		ResViewController.password = password;
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

	void setDepartment_id(long department_id) {
		ResViewController.department_id = department_id;
	}

	@RequestMapping(value = "/newReservationPage")
	public ModelAndView newReservationPage(String msg, String errorMsg){
		modelAndView.setViewName("reservation/resIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("newReservationPageActive", "active");
		modelAndView.addObject("myReservationPageActive","");
		modelAndView.addObject("profilePageActive", "");
		modelAndView.addObject("msg", msg);
		modelAndView.addObject("errorMsg", errorMsg);
		modelAndView.addObject("selectedTab", "../../jsp/reservation/search.jsp");
		return modelAndView;
		
	}

	@RequestMapping(value = "/myReservationPage")
	public ModelAndView myReservationPage(){
		modelAndView.setViewName("reservation/resIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("newReservationPageActive", "");
		modelAndView.addObject("myReservationPageActive","active");
		modelAndView.addObject("profilePageActive", "");
		if(resService.getAllMyreservations(userName) != null) {
			modelAndView.addObject("myReservations", resService.getAllMyreservations(userName));
		}else {
			modelAndView.addObject("noFoundMsg", "You don't have any reservation yet.");
		}
		modelAndView.addObject("selectedTab", "../../jsp/reservation/my-reservations.jsp");
		return modelAndView;
		
	}

	@RequestMapping(value = "/profilePage")
	public ModelAndView profilePage(String msg, String esg){
		if(msg == null || esg==null){
			msg = "";
			esg = "";
		}
		modelAndView.setViewName("reservation/resIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("newReservationPageActive", "");
		modelAndView.addObject("myReservationPageActive","");
		modelAndView.addObject("profilePageActive", "active");
		if(!msg.equals("")){
			modelAndView.addObject("sucMsg", msg);
		}else{
			modelAndView.addObject("eMsg", esg);
		}
		modelAndView.addObject("selectedTab", "../../jsp/reservation/profile.jsp");
		return modelAndView;
		
	}

	@RequestMapping(value = "/resourceSearch", method = RequestMethod.POST)
	public ModelAndView resourceSearch(@RequestParam String resourceID, String resourceUID, ArrayList<Resource> resources){
		modelAndView.setViewName("reservation/resIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("newReservationPageActive", "active");
		modelAndView.addObject("myReservationPageActive","");
		modelAndView.addObject("profilePageActive", "");
		if(resourceID != null && !resourceID.equalsIgnoreCase("")) {
			List<Resource> resourceList = new ArrayList<>();
			resourceList.add(invManagementService.getResourceByID(Long.parseLong(resourceID)));
			modelAndView.addObject("resourceList", resourceList);
			modelAndView.addObject("resourceName", invManagementService.getResourceByID(Long.parseLong(resourceID)).getName());
		}else{
			modelAndView.addObject("resourceList", resources);
		}
		modelAndView.addObject("resourceId",resourceID);
		modelAndView.addObject("resourceUID", resourceUID);

		modelAndView.addObject("selectedTab", "../../jsp/reservation/search.jsp");
		modelAndView.addObject("resultPage", "../../jsp/reservation/details.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/reservePrepare", method = RequestMethod.POST)
	public ModelAndView allResourceSearch(@RequestParam (value = "resourceParam", required = false) String resourceParam){
		String resourceID = "";
		String resourceUID = "";
		if(resourceParam != null && !resourceParam.equalsIgnoreCase("")) {
			resourceID = resourceParam.substring(0, resourceParam.indexOf("/"));
			resourceUID = resourceParam.substring(resourceParam.indexOf("/") + 1);
		}
		return resourceSearch(resourceID, resourceUID, (ArrayList<Resource>) invManagementService.getAllResource());
	}
	
	
	


}
