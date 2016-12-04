package concordia.soen387.project.Dao;

import java.util.List;

import concordia.soen387.project.Model.WhiteBoard;

/**
 * Created by Van Do on 2016-12-03.
 */
public interface WhiteBoardDao {
	
	void addWhiteBoard(WhiteBoard whiteBoard);
	void updateWhiteBoard(WhiteBoard whiteBoard);
	void deleteWhiteBoard(int id);
	WhiteBoard getWhiteBoardById(long id);
	List<WhiteBoard> getAllWhiteBoard();
	WhiteBoard getLastIndexWhiteboard();
}
