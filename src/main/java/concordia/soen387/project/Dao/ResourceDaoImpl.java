package concordia.soen387.project.Dao;

import concordia.soen387.project.Model.Resource;
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
public class ResourceDaoImpl implements ResourceDao {
    private JdbcTemplate jdbcTemplate;

    public ResourceDaoImpl(){}
    public ResourceDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addResource(Resource resource) {
        String sql = "INSERT INTO resource (id,available,description,moveable,name,resourceUID) " + "VALUE (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, resource.getId(),resource.getAvailable(),resource.getDescription(),
                resource.getMovable(),resource.getName(),resource.getResourceUID());
    }

    @Override
    public void updateResource(Resource resource) {
        if(resource != null) {
            String sql = "UPDATE resource SET id=?, available=?, description=?, " +
                    "moveable=?, name=?, resourceUID=? WHERE id=?";
            jdbcTemplate.update(sql, resource.getId(),resource.getAvailable(),resource.getDescription(),
                    resource.getMovable(),resource.getName(),resource.getResourceUID(), resource.getId());
        }
    }

    @Override
    public void deleteResource(int resourceID) {
        String sql = "DELETE FROM resource WHERE id="+resourceID;
        jdbcTemplate.execute(sql);
    }

    @Override
    public Resource getResourceById(long resourceID) {
        String sql = "SELECT * FROM resource WHERE id=" + resourceID;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Resource>() {
            @Override
            public Resource extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initResource(resultSet);
                }
                return null;
            }
        });
    }

    @Override
    public List<Resource> getAllResource() {
        String sql = "SELECT * FROM resource";
        List<Resource> resourceLists = jdbcTemplate.query(sql, new RowMapper<Resource>() {
            @Override
            public Resource mapRow(ResultSet resultSet, int i) throws SQLException {
                return initResource(resultSet);
            }
        });
        return resourceLists;
    }

    private Resource initResource(ResultSet resultSet) throws SQLException {
        Resource resource = new Resource();
        resource.setId(resultSet.getInt("id"));
        resource.setAvailable(resultSet.getBoolean("available"));
        resource.setDescription(resultSet.getString("description"));
        resource.setMovable(resultSet.getBoolean("moveable"));
        resource.setName(resultSet.getString("name"));
        resource.setResourceUID(resultSet.getInt("resourceUID"));

        return resource;
    }
}
