package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.BoardConVO;
import model.BoardVO;
import mybatis.MybatisSqlSessionFactory;

public class BoardDaoImpl implements IBoardDao{
	
	/**
	* Method : allboarlist
	* 작성자 : pc15
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 출력
	*/
	@Override
	public List<BoardVO> allboarlist(SqlSession sqlSession) {
		List<BoardVO> list = sqlSession.selectList("board.getAllBoard");
		return list;
	}

	/**
	* Method : insertBoard
	* 작성자 : pc15
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 추가
	*/
	@Override
	public int insertBoard(SqlSession sqlSession,BoardVO vo) {
		int cnt = sqlSession.insert("board.insertBoard",vo);
		return cnt;
	}

	@Override
	public int updateBoard(SqlSession sqlSession, BoardVO vo) {
		int cnt= sqlSession.update("board.updateBoard", vo);
		return cnt;
	}

	@Override
	public List<BoardConVO> getAllBoardCon(SqlSession sqlSession, String str) {
		List<BoardConVO> list = sqlSession.selectList("board.getAllBoardCon", str);
		return list;
	}

	@Override
	public int insetContent(SqlSession sqlSession, BoardConVO vo) {
		int cnt = sqlSession.insert("board.insertContetn", vo);
		return cnt;
	}
	
}
