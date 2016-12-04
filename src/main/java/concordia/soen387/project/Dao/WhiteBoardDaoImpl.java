package concordia.soen387.project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import concordia.soen387.project.Model.WhiteBoard;
/**
 * Created by Van Do on 2016-12-03.
 */
public class WhiteBoardDaoImpl implements WhiteBoardDao{

	private JdbcTemplate jdbcTemplate;
	
	public WhiteBoardDaoImpl(){}
	public WhiteBoardDaoImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void addWhiteBoard(WhiteBoard whiteBoard) {
		 String sql = "INSERT INTO whiteboard (height,width,id) VALUE (?,?,?)";
		 jdbcTemplate.update(sql, whiteBoard.getHeight(), whiteBoard.getWidth(), whiteBoard.getId());
		
	}

	@Override
	public void updateWhiteBoard(WhiteBoard whiteBoard) {
		if(!(whiteBoard.getId() < 0)){
			String sql = "UPDATE whiteboard SET height=?, width=?, id=? WHERE id=?";
			jdbcTemplate.update(sql, whiteBoard.getHeight(), whiteBoard.getWidth(), whiteBoard.getId(), whiteBoard.getId());
		}
		
	}

	@Override
	public void deleteWhiteBoard(int id) {
		String sql = "DELETE FROM whiteboard WHERE id=?";
	    jdbcTemplate.update(sql, id);
		
	}

	@Override
	public WhiteBoard getWhiteBoardById(long id) {
		String sql = "SELECT * FROM whiteboard WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<WhiteBoard>() {
            @Override
            public WhiteBoard extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    return initWhiteBoard(resultSet);
                }

                return null;
            }
        });
	}

	@Override
	public List<WhiteBoard> getAllWhiteBoard() {
		String sql = "SELECT * FROM whiteboard";
        List<WhiteBoard> whiteBoardList = jdbcTemplate.query(sql, new RowMapper<WhiteBoard>() {
            @Override
            public WhiteBoard mapRow(ResultSet resultSet, int i) throws SQLException {
                return initWhiteBoard(resultSet);
            }
        });

        return whiteBoardList;
	}

	@Override
	public WhiteBoard getLastIndexWhiteboard() {
		String sql = "SELECT * FROM whiteboard where id = (select max(id) from whiteboard)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<WhiteBoard>() {
			@Override
			public WhiteBoard extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if(resultSet.next()){
					return initWhiteBoard(resultSet);
				}
				return null;
			}
		});
	}

	private WhiteBoard initWhiteBoard(ResultSet resultSet) throws SQLException{
		WhiteBoard whiteBoard = new WhiteBoard();
		whiteBoard.setHeight(resultSet.getInt("height"));
		whiteBoard.setWidth(resultSet.getInt("width"));
		whiteBoard.setId(resultSet.getInt("id"));
		return whiteBoard;
	}

}
