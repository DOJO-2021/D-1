package test;

import java.util.List;

import dao.BoardDAO;
import model.BoardBeans;

public class BoardDAOTest {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();

	//select文のtest
	System.out.println("----------select文テスト----------");
	List<BoardBeans> BoardList = dao.select(new BoardBeans(null,3,""));
	}
}
