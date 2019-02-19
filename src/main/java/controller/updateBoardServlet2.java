package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.BoardServiceImpl;
import service.IBoardService;
import model.BoardVO;

@WebServlet("/updateBoard2")
public class updateBoardServlet2 extends HttpServlet {
	
	IBoardService service;
	
	public updateBoardServlet2() {
		service = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("boardnameup");		
		String sel = request.getParameter("selup");
		String num = request.getParameter("hid");
		
		Logger logger = LoggerFactory.getLogger(updateBoardServlet.class);
		
		logger.debug("*************************");
		logger.debug(name);
		logger.debug(sel);
		logger.debug(num);
		logger.debug("*************************");
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_name(name);
		bvo.setBoard_use(sel);
		bvo.setBoard_num(num);
		
		service.updateBoard(bvo);
		HttpSession session = request.getSession();
		List<BoardVO> blist = service.allboarlist();
		request.setAttribute("blist", blist);
		session.setAttribute("blist", blist);
		
		request.getRequestDispatcher("crboard.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
