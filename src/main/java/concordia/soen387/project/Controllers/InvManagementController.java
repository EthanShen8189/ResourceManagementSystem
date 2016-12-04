package concordia.soen387.project.Controllers;


import concordia.soen387.project.Model.Resource;
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
                return invViewController.manageInventory(resourceArrayList, "");
            } else {
                return invViewController.manageInventory(null, "Wrong Resource ID");
            }
        }else{
            return invViewController.manageInventory(null, "Please enter resource ID or click See All Resource");
        }

    }

    @RequestMapping(value = "/searchAllResource", method = RequestMethod.GET)
    public ModelAndView searchResource(){
        return invViewController.manageInventory((ArrayList<Resource>) resourceService.getAllResource(), "");
    }

    @RequestMapping(value = "/editResource", method = RequestMethod.GET, params = {"editParam"})
    public ModelAndView modifyResource(@RequestParam String editParam){
        return null;
    }
}
