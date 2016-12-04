package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.Department;

/**
 * Created by Van Do on 2016-12-03.
 */
public class DepartmentDaoImpl implements DepartmentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public DepartmentDaoImpl(){}
	public DepartmentDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addDepartment(Department department) {
		String sql = "INSERT INTO department (id,name) VALUE (?,?)";
		 jdbcTemplate.update(sql, department.getId(), department.getName());
		
	}

	@Override
	public void updateDepartment(Department department) {
		if(!(department.getName().equalsIgnoreCase(""))){
			String sql = "UPDATE department SET id=?, name=? WHERE id=?";
			jdbcTemplate.update(sql, department.getId(), department.getName(), department.getId());
		}
	}

	@Override
	public void deleteDepartment(int departID) {
		String sql = "DELETE FROM department WHERE id=?";
	    jdbcTemplate.update(sql, departID);
		
	}

	@Override
	public Department getDepartmentById(int departID) {
		String sql = "SELECT * FROM department WHERE id=" + departID;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {
            @Override
            public Department extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initDepartment(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<Department> getAllReservation() {
		String sql = "SELECT * FROM department";
        List<Department> departmentList = jdbcTemplate.query(sql, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                return initDepartment(resultSet);
            }
        });

        return departmentList;
	}
	
	private Department initDepartment(ResultSet resultSet) throws SQLException{
		Department department = new Department();
		department.setId(resultSet.getInt("id"));
		department.setName(resultSet.getString("name"));
		return department;
	}

}
