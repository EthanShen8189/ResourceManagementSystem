package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Employee;

import java.util.List;

/**
 * Created by EthanShen on 2016-12-03.
 */
public interface EmployeeDao {

    void addUser(Employee employee);
    void updateUser(Employee employee);
    void deleteUser(String username, int departID);
    Employee getUserById(String username, int departID);
    List<Employee> getAllEmployee();

}
