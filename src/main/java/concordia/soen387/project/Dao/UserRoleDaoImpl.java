package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.UserRole;

/**
 * Created by Van Do on 2016-12-03.
 */
public class UserRoleDaoImpl implements UserRoleDao{

	private JdbcTemplate jdbcTemplate;
	
	public UserRoleDaoImpl(){}
	public UserRoleDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addUserRole(UserRole userRole) {
		String sql = "INSERT INTO user_role (id,user_role_human_readable) VALUE (?,?)";
		jdbcTemplate.update(sql, userRole.getId(), userRole.getUser_role_human_readable());
		
	}

	@Override
	public void updateUserRole(UserRole userRole) {
		if(!(userRole.getUser_role_human_readable().equalsIgnoreCase(""))){
			String sql = "UPDATE user_role SET id=?, user_role_human_readable=? WHERE id=?";
			jdbcTemplate.update(sql,userRole.getId(), userRole.getUser_role_human_readable(), userRole.getId());
		}
		
	}

	@Override
	public void deleteUserRole(int id) {
		String sql = "DELETE FROM user_role WHERE id=?";
	     jdbcTemplate.update(sql, id);
		
	}

	@Override
	public UserRole getUserRoleById(int id) {
		String sql = "SELECT * FROM user_role WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<UserRole>() {
            @Override
            public UserRole extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initUserRole(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		String sql = "SELECT * FROM user_role";
        List<UserRole> userRoleList = jdbcTemplate.query(sql, new RowMapper<UserRole>() {
            @Override
            public UserRole mapRow(ResultSet resultSet, int i) throws SQLException {
                return initUserRole(resultSet);
            }
        });

        return userRoleList;
	}
	
	private UserRole initUserRole(ResultSet resultSet) throws SQLException{
		UserRole userRole = new UserRole();
		userRole.setId(resultSet.getInt("id"));
		userRole.setUser_role_human_readable(resultSet.getString("user_role_human_readable"));
		return userRole;
	}


}
