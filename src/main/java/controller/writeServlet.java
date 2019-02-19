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

@WebServlet("/write")
public class writeServlet extends HttpServlet {
	
	IBoardService service;
	
	public writeServlet() {
		service = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("createForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String con = request.getParameter("con");
		String file = request.getParameter("file");
		
		BoardConVO bvo = new BoardConVO();
		bvo.setBoard_con(con);
		bvo.setBoard_title(title);
		
		
		HttpSession session = request.getSession();
		request.setAttribute("boardName", session.getAttribute("boardName"));
		String name = (String) session.getAttribute("boardName");
		List<BoardConVO> bclist = service.getAllBoardCon(name);
		request.setAttribute("bclist", bclist);
		
		request.getRequestDispatcher("boardPaging.jsp").forward(request, response);
	}

}
