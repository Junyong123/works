package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.BoardConVO;
import model.BoardVO;

public interface IBoardDao {
	List<BoardVO> allboarlist(SqlSession sqlSession);
	
	int insertBoard(SqlSession sqlSession,BoardVO vo);
	
	int updateBoard(SqlSession sqlSession,BoardVO vo);
	
	List<BoardConVO> getAllBoardCon(SqlSession sqlSession,String str);
}
