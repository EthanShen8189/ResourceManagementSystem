package concordia.soen387.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResViewController {
	
	private static ResViewController resViewController = new ResViewController();
	private ModelAndView modelAndView = new ModelAndView();
	private static String userName;
	private static String firstName;
	private static long department_id;
	//private ResNavigationBarService resNavigationBarService = new ResNavigationBarService();

	private ResViewController(){}

	static ResViewController getResViewController(){
		return resViewController;
	}

	public void setUserName(String userName) {
		ResViewController.userName = userName;
	}

	public void setFirstName(String firstName) {
		ResViewController.firstName = firstName;
	}

	public void setDepartment_id(long department_id) {
		ResViewController.department_id = department_id;
	}

	@RequestMapping(value = "/newReservationPage")
	public ModelAndView newReservationPage(){
		modelAndView.setViewName("reservation/resIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("newReservationPageActive", "active");
		modelAndView.addObject("myReservationPageActive","");
		modelAndView.addObject("profilePageActive", "");
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
		modelAndView.addObject("selectedTab", "../../jsp/reservation/my-reservations.jsp");
		return modelAndView;
		
	}

	@RequestMapping(value = "/profilePage")
	public ModelAndView profilePage(){
		modelAndView.setViewName("reservation/resIndex");
		modelAndView.addObject("name", firstName);
		modelAndView.addObject("username", userName);
		modelAndView.addObject("departmentId", department_id);
		modelAndView.addObject("newReservationPageActive", "");
		modelAndView.addObject("myReservationPageActive","");
		modelAndView.addObject("profilePageActive", "active");
		modelAndView.addObject("selectedTab", "../../jsp/reservation/profile.jsp");
		return modelAndView;
		
	}

	@RequestMapping(value = "/resourceSearch", method = RequestMethod.GET)
	public ModelAndView resourceSearch(@RequestParam String resourceSearch){
		modelAndView.setViewName("reservation/resIndex");
	}
	
	
	


}
