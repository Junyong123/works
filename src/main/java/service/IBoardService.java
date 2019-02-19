package service;

import java.util.List;

import model.BoardConVO;
import model.BoardVO;

import org.apache.ibatis.session.SqlSession;

public interface IBoardService {
	List<BoardVO> allboarlist();
	
	int insertBoard(BoardVO vo);

	int updateBoard(BoardVO vo);
	
	List<BoardConVO> getAllBoardCon(String str);
}
