package service;

import java.util.List;

import model.BoardConVO;
import model.BoardVO;
import mybatis.MybatisSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.BoardDaoImpl;
import dao.IBoardDao;

public class BoardServiceImpl implements IBoardService{

	IBoardDao service;
	
	public BoardServiceImpl() {
		service = new BoardDaoImpl();
	}
	
	@Override
	public List<BoardVO> allboarlist() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardVO> list = service.allboarlist(sqlSession);
		
		sqlSession.close();
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int cnt = service.insertBoard(sqlSession, vo);
		
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int cnt = service.updateBoard(sqlSession, vo);
		
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	@Override
	public List<BoardConVO> getAllBoardCon(String str) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardConVO> list = service.getAllBoardCon(sqlSession, str);
		
		sqlSession.close();
		return list;
	}

	@Override
	public int insetContent(BoardConVO vo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int cnt = service.insetContent(sqlSession, vo);
		
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
}
