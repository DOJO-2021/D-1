package test;

import java.util.List;

import dao.BoardDAO;
import model.BoardBeans;

public class BoardDAOTest {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();

	//select文のtest
	System.out.println("----------select文テスト----------");
	List<BoardBeans> BoardList = dao.select(new BoardBeans("saburou", 1, 1, ""));
	for(BoardBeans Ccard : BoardList) {
		System.out.println(Ccard.getId());
		System.out.println(Ccard.getM_number());
		System.out.println(Ccard.getType());
		System.out.println(Ccard.getContents());
		System.out.println();
	}

	// insert()のテスト
	System.out.println("---------- insert()のテスト ----------");
	BoardBeans insRec = new BoardBeans("asa", 0, 6,"hello world");
	if (dao.insert(insRec)) {
		System.out.println("登録成功！");
	}
	else {
		System.out.println("登録失敗！");
	}

	}
}
