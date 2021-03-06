package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import encrypt.kisa.sha256.KISA_SHA256;
import model.BoardVO;
import model.UserVO;
import service.BoardServiceImpl;
import service.IBoardService;
import service.IUserService;
import service.UserServiceImpl;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	IUserService userser;
	IBoardService service;
	
	@Override
	public void init() throws ServletException {
		userser = new UserServiceImpl();
		service = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = LoggerFactory.getLogger(loginServlet.class);
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String transpass = KISA_SHA256.encrypt(password);
		logger.debug("*******************");
		logger.debug(userId);
		logger.debug(password);
		logger.debug(transpass);
		logger.debug("*******************");
		
		List<UserVO> uvolist = userser.getAllUser();
		HttpSession session = request.getSession();
		List<BoardVO> blist = service.allboarlist();
		session.setAttribute("blist", blist);

		for(UserVO uvo : uvolist){
			if(uvo.getUserId().equals(userId)){
				if(uvo.getPass().equals(transpass)){
					session.setAttribute("uvo", uvo);
					session.setMaxInactiveInterval(1800);
					request.getRequestDispatcher("/main.jsp").forward(request, response);
				}
			}
		}
		request.getRequestDispatcher("/login.jsp").include(request, response);
	}

}
