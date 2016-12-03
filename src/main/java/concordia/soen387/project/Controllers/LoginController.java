package concordia.soen387.project.Controllers;

import concordia.soen387.project.Services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by EthanShen on 2016-11-17.
 */
@Controller
public class LoginController {

    private LoginService loginService = new LoginService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/home" ,method = RequestMethod.POST, params = {"employeeType","username", "password"})
    public String handleLoginRequest(@RequestParam String employeeType,
                                     @RequestParam String username,
                                     @RequestParam String password,
                                     ModelMap model){
        if(username.equals("") || password.equals("")){
            model.put("errorMsg", "Please Enter Employee ID and Password.");
            return "login";

        }else{
            String name = loginService.loginValidation(employeeType, username, password);
            if(!name.equalsIgnoreCase("") && employeeType.toLowerCase().contains("admin")) {
                model.put("name", name.substring(name.indexOf(":")));
                model.put("username", name.substring(0,name.indexOf(":")));
                return "inventory/invIndex";

            }else if(!name.equalsIgnoreCase("") && employeeType.toLowerCase().contains("employee")){
                model.put("name", name.substring(name.indexOf(":")));
                model.put("username", name.substring(0,name.indexOf(":")));
                return "reservation/resIndex";

            }else{
                model.put("errorMsg", "Invalid Credential!");
                return "login";
            }
        }

    }

}
