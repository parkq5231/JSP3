package co.micol.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO {// 상위 DAO 상속받아서 만든단 소리
	// 보드테이블 접속하는 DAO
	private PreparedStatement psmt;
	private ResultSet rs;// recordset을 담는다?
	// sequal
	private final String BOARDSELECTLIST = "SELECT * FROM BOARDS ORDER BY BOARD_NO DESC";
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO=?";
	private final String BOARDINSERT = "INSERT INTO BOARDS VALUES(?,?,?,?,?)";
	private final String BOARDDELETE = "DELETE FROM BOARDS WHERE BOARD_NO=?";

	public ArrayList<BoardVO> selectList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;

		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);// 연결하는거
			rs = psmt.executeQuery();// 동작시키는거 //recordset을 리턴시킨다=Resultset과 동일
			while (rs.next()) {// cursor의 위치 생각(plsql)
				vo = new BoardVO();// vo객체 초기화
				vo.setBoardNo(rs.getInt("board_no"));// vo에 set으로 값을 넣을거
				vo.setTitle(rs.getString("title"));// rs란 recordset이 가지고 있는 get타입의 어떤 칼럼을 적는거
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public BoardVO select(BoardVO vo) {
		// 한개의 record만 갖고오고 싶을 때

		try {
			psmt = conn.prepareStatement(BOARDSELECT);// 시퀄
			psmt.setInt(1, vo.getBoardNo());
			rs = psmt.executeQuery();
			if (rs.next()) {// 존재유무 확인
				vo.setBoardNo(rs.getInt("board_no"));// vo에 set으로 값을 넣을거
				vo.setTitle(rs.getString("title"));// rs란 recordset이 가지고 있는 get타입의 어떤 칼럼을 적는거
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public int insert(BoardVO vo) { // boards 테이블에 데이터를 삽입
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDINSERT);
			psmt.setInt(1, vo.getBoardNo());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setDate(5, vo.getCreationDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int update(BoardVO vo) {
		int n = 0;
		// 여기에 수정
		return n;
	}

	public int delete(BoardVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDDELETE);
			psmt.setInt(1, vo.getBoardNo());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	//
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)//
				conn.close();
			System.out.println("DB연결 종료!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
