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
import model.BoardConVO;
import model.BoardVO;

@WebServlet("/board")
public class boardServlet extends HttpServlet {
	
	IBoardService service;
	
	public boardServlet() {
		service = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String test = request.getParameter("board_name");
		HttpSession session = request.getSession();
		List<BoardConVO> bclist = service.getAllBoardCon(test);
		request.setAttribute("bclist", bclist);
		request.setAttribute("boardName", test);
		session.setAttribute("bclist", bclist);
		session.setAttribute("boardName", test);
		
		request.getRequestDispatcher("boardPaging.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
