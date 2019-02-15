package service;

import java.util.List;
import java.util.Map;

import model.PageVO;
import model.UserVO;

import org.apache.ibatis.session.SqlSession;


public interface IUserService {
	
	/**
	 * Method : getAllUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
 	 * Method 설명 : 전체 사용자 정보 조회
	 */
	List<UserVO> getAllUser();
	
	/**
	 * Method : selectUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 조회
	 */
	UserVO selectUser(String userId);
	
	/**
	 * Method : selectUserPagingList
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 사용자 페이지 리스트 조회
	 */
	Map<String, Object> selectUserPagingList(PageVO pageVO);
	
	int insertUser(UserVO vo);
	
	int updateUser(UserVO vo);
	
	int encryptPass();
}