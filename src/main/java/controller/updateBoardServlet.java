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

@WebServlet("/updateBoard")
public class updateBoardServlet extends HttpServlet {
	
	IBoardService service;
	
	public updateBoardServlet() {
		service = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("boardname");		
		String sel = request.getParameter("sel");
		
		Logger logger = LoggerFactory
				.getLogger(updateBoardServlet.class);
		
		logger.debug("*************************");
		logger.debug(name);
		logger.debug(sel);
		logger.debug("*************************");
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_name(name);
		bvo.setBoard_use(sel);

		service.insertBoard(bvo);
		HttpSession session = request.getSession();
		List<BoardVO> blist = service.allboarlist();
		request.setAttribute("blist", blist);
		session.setAttribute("blist", blist);
		
		request.getRequestDispatcher("crboard.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
