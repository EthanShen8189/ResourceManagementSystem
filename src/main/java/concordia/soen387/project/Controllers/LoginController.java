package concordia.soen387.project.Controllers;

import concordia.soen387.project.Services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by EthanShen on 2016-11-17.
 */
@Controller
public class LoginController {

    private LoginService loginService = new LoginService();
    private ModelAndView modelAndView = new ModelAndView();
    private InvViewController invViewController = InvViewController.getInvViewController();
    private ResViewController resViewController = ResViewController.getResViewController();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/home" ,method = RequestMethod.POST, params = {"employeeType","username", "password"})
    public ModelAndView handleLoginRequest(@RequestParam String employeeType,
                                           @RequestParam String username,
                                           @RequestParam String password,
                                           ModelMap model){
        if(username.equals("") || password.equals("")){
            modelAndView.setViewName("login");
            model.put("errorMsg", "Please Enter Employee ID and Password.");
            return modelAndView;

        }else{
            String name = loginService.loginValidation(employeeType, username, password);
            if(!name.equalsIgnoreCase("") && employeeType.toLowerCase().contains("admin")) {
                modelAndView.setViewName("inventory/invIndex");

                modelAndView.addObject("name", name.substring(name.indexOf(":")+1, name.indexOf("+")));
                modelAndView.addObject("username", name.substring(0,name.indexOf(":")));

                invViewController.setUserName(name.substring(0,name.indexOf(":")));
                invViewController.setFirstName(name.substring(name.indexOf(":")+1, name.indexOf("+")));
                invViewController.setPassword(password);
                invViewController.setDepartment_id(Long.parseLong(name.substring(name.indexOf("+")+1)));
                return modelAndView;

            }else if(!name.equalsIgnoreCase("") && employeeType.toLowerCase().contains("employee")){
                modelAndView.setViewName("reservation/resIndex");

                modelAndView.addObject("name", name.substring(name.indexOf(":")+1, name.indexOf("+")));
                modelAndView.addObject("username", name.substring(0,name.indexOf(":")));

                resViewController.setUserName(name.substring(0,name.indexOf(":")));
                resViewController.setFirstName(name.substring(name.indexOf(":")+1, name.indexOf("+")));
                resViewController.setPassword(password);
                resViewController.setDepartment_id(Long.parseLong(name.substring(name.indexOf("+")+1)));
                return modelAndView;

            }else{
                modelAndView.setViewName("login");
                model.put("errorMsg", "Invalid Credential!");
                return modelAndView;
            }
        }

    }

}
