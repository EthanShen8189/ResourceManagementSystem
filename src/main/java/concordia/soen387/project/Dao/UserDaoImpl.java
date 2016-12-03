package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by EthanShen on 2016-12-03.
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(){}
    public UserDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO employee (username,email,first_name, last_name," +
                        " password_encrypted, phone, department_id) " + "VALUE (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getEmail(),user.getFirst_name(),
                                user.getLast_name(), user.getPassword(), user.getPhone(), user.getDepartment_id());
    }

    @Override
    public void updateUser(User user) {
        if(!(user.getUsername().equalsIgnoreCase("") && user.getDepartment_id()>0)){
            String sql = "UPDATE employee SET username=?, email=?, first_name=?, " +
                    "last_name=?, password_encrypted=?, phone=?, department_id=? WHERE username=? AND department_id=?";
            jdbcTemplate.update(sql,user.getUsername(),user.getEmail(),user.getFirst_name(),
                    user.getLast_name(), user.getPassword(), user.getPhone(), user.getDepartment_id(),
                    user.getUsername(),user.getDepartment_id());
        }
    }
    
    @Override
    public void deleteUser(String username, int departID) {
        String sql = "DELETE FROM employee WHERE username=? AND department_id=?";
        jdbcTemplate.update(sql, username, departID);
    }

    @Override
    public User getUserById(String username, int departID) {
        String sql = "SELECT * FROM emplyee WHERE username=" + username + "AND department_id=" + departID;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initUser(resultSet);
                }

                return null;
            }
        });
    }

    @Override
    public List<User> getAllReservation() {
        String sql = "SELECT * FROM employee";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return initUser(resultSet);
            }
        });

        return userList;
    }

    private User initUser(ResultSet resultSet) throws SQLException{
        User user= new User();
        user.setUsername(resultSet.getString("username"));
        user.setDepartment_id(resultSet.getInt("department_id"));
        user.setEmail(resultSet.getString("email"));
        user.setFirst_name(resultSet.getString("first_name"));
        user.setLast_name(resultSet.getString("last_name"));
        user.setPhone(resultSet.getString("phone"));
        user.setPassword(resultSet.getString("password_encrypted"));

        return user;
    }
}
