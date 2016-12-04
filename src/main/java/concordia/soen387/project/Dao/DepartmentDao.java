package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.Department;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface DepartmentDao {

	void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int departID);
    Department getDepartmentById(int departID);
    List<Department> getAllReservation();
}
