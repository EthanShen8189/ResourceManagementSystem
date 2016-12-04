package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.UserRole;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface UserRoleDao {
	
	void addUserRole(UserRole userRole);
	void updateUserRole(UserRole userRole);
	void deleteUserRole(int id);
	UserRole getUserRoleById(int id);
	List<UserRole> getAllUserRoles();

}
