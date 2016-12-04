package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Employee;
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
public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(){}
    public EmployeeDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addUser(Employee employee) {
        String sql = "INSERT INTO employee (username,email,first_name, last_name," +
                        " password_encrypted, phone, department_id) " + "VALUE (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, employee.getUsername(), employee.getEmail(), employee.getFirst_name(),
                                employee.getLast_name(), employee.getPassword(), employee.getPhone(), employee.getDepartment_id());
    }

    @Override
    public void updateUser(Employee employee) {
        if(!employee.getUsername().equalsIgnoreCase("")){

            String sql = "UPDATE employee SET username=?, email=?, first_name=?, " +
                    "last_name=?, password_encrypted=?, phone=?, department_id=? WHERE username=? AND department_id=?";
            jdbcTemplate.update(sql, employee.getUsername(), employee.getEmail(), employee.getFirst_name(),
                    employee.getLast_name(), employee.getPassword(), employee.getPhone(), employee.getDepartment_id(),
                    employee.getUsername(), employee.getDepartment_id());
        }
    }
    
    @Override
    public void deleteUser(String username, int departID) {
        String sql = "DELETE FROM employee WHERE username=? AND department_id=?";
        jdbcTemplate.update(sql, username, departID);
    }

    @Override
    public Employee getUserById(String username, int departID) {
        String sql = "SELECT * FROM employee WHERE username=" + "\'"+username+"\'"+" AND department_id=" + departID;

        return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
            @Override
            public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initUser(resultSet);
                }

                return null;
            }
        });
    }

    @Override
    public List<Employee> getAllEmployee() {
        String sql = "SELECT * FROM employee";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                return initUser(resultSet);
            }
        });

        return employeeList;
    }

    private Employee initUser(ResultSet resultSet) throws SQLException{
        Employee employee = new Employee();
        employee.setUsername(resultSet.getString("username"));
        employee.setDepartment_id(resultSet.getInt("department_id"));
        employee.setEmail(resultSet.getString("email"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setPhone(resultSet.getString("phone"));
        employee.setPassword(resultSet.getString("password_encrypted"));

        return employee;
    }
}
