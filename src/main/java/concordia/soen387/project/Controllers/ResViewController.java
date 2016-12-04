package concordia.soen387.project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ResViewController {
	
	private ModelAndView modelAndView = new ModelAndView();
	//private ResNavigationBarService resNavigationBarService = new ResNavigationBarService();
	
	//accountSettings
	@RequestMapping(value = "/accountSettingsTab")
	public ModelAndView accountSettingsNav(){
		modelAndView.setViewName("resIndex");
		modelAndView.addObject("accountSettingsTabActive", "active");
		modelAndView.addObject("reservationsTabActive","");
		modelAndView.addObject("addReservationTabActive", "");
		modelAndView.addObject("selectedTab", "../jsp/inventory/accountSettings.jsp");
		return modelAndView;
		
	}
	
	//reservationsTab
	@RequestMapping(value = "/reservationsTab")
	public ModelAndView reservationsNav(){
		modelAndView.setViewName("resIndex");
		modelAndView.addObject("accountSettingsTabActive", "");
		modelAndView.addObject("reservationsTabActive","active");
		modelAndView.addObject("addReservationTabActive", "");
		modelAndView.addObject("selectedTab", "../jsp/reservation/my-reservations.jsp");
		return modelAndView;
		
	}
	
	
	//addreservationsTab
	@RequestMapping(value = "/addReservationTab")
	public ModelAndView addReservationNav(){
		modelAndView.setViewName("resIndex");
		modelAndView.addObject("accountSettingsTabActive", "");
		modelAndView.addObject("reservationsTabActive","");
		modelAndView.addObject("addReservationTabActive", "active");
		modelAndView.addObject("selectedTab", "../jsp/inventory/search.jsp");
		return modelAndView;
		
	}
	
	
	


}
