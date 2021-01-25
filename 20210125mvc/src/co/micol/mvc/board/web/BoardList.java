package co.micol.mvc.board.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardsDAO dao = new BoardsDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();	//값을 돌려 받아야 하니 VO를 사용한듯
		
		list = dao.selectList();//list는 dao가 가지고 있는 메소드를 사용하면 된다 //실제 테이블에 접속해서 list를 가져온다
		request.setAttribute("list", list);//dispatcher로 보낼 때 필요한 작업
		String viewPage = "views/board/boardList.jsp";//결과를 보여줄 view페이지
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);//돌려줄 page path에 작성
		dispatcher.forward(request, response);
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
