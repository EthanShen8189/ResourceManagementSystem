package concordia.soen387.project.Services;

import concordia.soen387.project.Dao.EmployeeDao;
import concordia.soen387.project.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by EthanShen on 2016-12-02.
 */
public class LoginService {
    static ApplicationContext context;

    @Autowired
    static EmployeeDao employeeDao;

    static {
        if(context==null){
            context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        }
        if(employeeDao == null){
            employeeDao = (EmployeeDao) context.getBean("employeeDao");
        }
    }

    public String loginValidation(String employeeType, String username, String password){

        return validCredential(employeeType,username,password);
    }

    private String validCredential(String employeeType, String username, String password) {
        Employee employee;
        if(employeeType.toLowerCase().contains("admin")){
            employee = employeeDao.getUserById(username, 100);
            if(employee != null) {
                if (employee.getPassword().equals(password)) {
                    return employee.getUsername()+":"+employee.getFirst_name()+"+"+employee.getDepartment_id();
                }
            }

        }else if(employeeType.toLowerCase().contains("employee")){
            employee = employeeDao.getUserById(username, 200);
            if(employee != null) {
                if (employee.getPassword().equals(password)) {
                    return employee.getUsername()+":"+employee.getFirst_name()+"+"+employee.getDepartment_id();
                }
            }
        }
        return "";
    }
}
