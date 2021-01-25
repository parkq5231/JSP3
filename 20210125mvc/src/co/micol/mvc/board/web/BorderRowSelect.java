package co.micol.mvc.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

@WebServlet("/BorderRowSelect.do")
public class BorderRowSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderRowSelect() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardsDAO dao = new BoardsDAO();
		BoardVO vo = new BoardVO();

		int row = Integer.parseInt(request.getParameter("row"));// survlet값 가져오는거 html에서 넘어올 땐 문자로 넘어옴(문자 ->숫자 바꿔주는부분)
		vo.setBoardNo(row);

		vo = dao.select(vo);// DB호출
		request.setAttribute("vo", vo);//JSP에서 쓸 값 보내줌
		String viewPage = "views/board/boardSelect.jsp";// 돌려줄 페이지

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
