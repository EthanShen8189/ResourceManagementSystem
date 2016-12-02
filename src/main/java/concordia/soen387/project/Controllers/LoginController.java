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

    @RequestMapping(value="/login" ,method = RequestMethod.POST, params = {"username", "password"})
    public String handleLoginRequest(@RequestParam String username,
                                     @RequestParam String password,
                                     ModelMap model){
        if(username.equals("") || password.equals("")){
            model.put("errorMsg", "Please Enter User Name and Password.");
            return "login";

        }else{
            if(loginService.loginValidation(username, password)) {
                model.put("name", username);
                return "index";
            }else{
                model.put("errorMsg", "Invalid Credential!");
                return "login";
            }
        }

    }

    @RequestMapping(value="/login" ,method = RequestMethod.POST, params = {})
    public String backToSearchPage(ModelMap model){
        model.put("name", "admin");
        return "index";

    }

}
