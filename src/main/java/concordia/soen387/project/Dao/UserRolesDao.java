package concordia.soen387.project.Dao;

import java.util.List;


import concordia.soen387.project.Model.UserRoles;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface UserRolesDao {
	
	void addUsersRoles(UserRoles userRoles);
	void updateUsersRoles(UserRoles userRoles);
	void deleteUsersRoles(String username);
	UserRoles getUsersRolesByUsername(String username);
	List<UserRoles> getAllUsersRoles();

}
