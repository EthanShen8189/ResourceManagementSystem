package concordia.soen387.project.Services;

/**
 * Created by EthanShen on 2016-12-02.
 */
public class LoginService {

    public Boolean loginValidation(String username, String password) {
        return (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"));
    }
}
