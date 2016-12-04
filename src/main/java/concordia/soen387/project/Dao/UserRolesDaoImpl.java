package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.UserRoles;

/**
 * Created by Van Do on 2016-12-03.
 */
public class UserRolesDaoImpl implements UserRolesDao{

	private JdbcTemplate jdbcTemplate;
	
	public UserRolesDaoImpl(){}
	public UserRolesDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addUsersRoles(UserRoles userRoles) {
		 String sql = "INSERT INTO user_roles (user_username,roles_id) VALUE (?,?)";
		 jdbcTemplate.update(sql, userRoles.getUser_username(), userRoles.getRoles_id());
		
	}

	@Override
	public void updateUsersRoles(UserRoles userRoles) {
		if(!(userRoles.getUser_username().equalsIgnoreCase(""))){
			String sql = "UPDATE user_roles SET user_username=?, roles_id=? WHERE user_username=? AND roles_id=?";
			jdbcTemplate.update(sql, userRoles.getUser_username(), userRoles.getRoles_id(),userRoles.getUser_username(), userRoles.getRoles_id());
		}
		
	}

	@Override
	public void deleteUsersRoles(String username) {
		String sql = "DELETE FROM user_roles WHERE user_username=?";
	    jdbcTemplate.update(sql, username);
		
	}

	@Override
	public UserRoles getUsersRolesByUsername(String username) {
		 String sql = "SELECT * FROM user_roles WHERE user_username=" + username;
	        return jdbcTemplate.query(sql, new ResultSetExtractor<UserRoles>() {
	            @Override
	            public UserRoles extractData(ResultSet resultSet) throws SQLException, DataAccessException {
	                if(resultSet.next()){
	                    return initUserRoles(resultSet);
	                }

	                return null;
	            }
	        });
	}

	@Override
	public List<UserRoles> getAllUsersRoles() {
		String sql = "SELECT * FROM user_roles";
        List<UserRoles> userRolesList = jdbcTemplate.query(sql, new RowMapper<UserRoles>() {
            @Override
            public UserRoles mapRow(ResultSet resultSet, int i) throws SQLException {
                return initUserRoles(resultSet);
            }
        });

        return userRolesList ;
	}
	
	private UserRoles initUserRoles(ResultSet resultSet) throws SQLException{
		UserRoles userRoles = new UserRoles();
		userRoles.setUser_username(resultSet.getString("user_username"));
		userRoles.setRoles_id(resultSet.getInt("roles_id"));
		return userRoles;
	}

}
